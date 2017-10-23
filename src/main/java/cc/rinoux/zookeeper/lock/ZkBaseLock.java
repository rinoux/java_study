package cc.rinoux.zookeeper.lock;


import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class ZkBaseLock {
    private static final String LOCK_ID_SPLIT = "-lock-";

    /**
     * 重试获取锁次数
     */
    private static final Integer MAX_RETRY_COUNT = 10;

    private final ZkClient client;
    /**
     * 锁节点
     */
    private final String path;
    /**
     * 根节点
     */
    private final String basePath;
    private final String lockName;

    public ZkBaseLock(ZkClient client, String basePath, String lockName) {
        this.client = client;
        this.basePath = basePath;
        this.path = basePath.concat("/").concat(lockName);
        this.lockName = lockName;
    }

    /**
     * 等待获取锁
     *
     * @param startMillis
     * @param millisToWait
     * @param currentNode
     * @return
     * @throws Exception
     */
    private boolean waitLock(long startMillis, Long millisToWait, String currentNode) throws LockException {

        // 是否得到锁
        boolean locked = false;
        // 是否需要删除当前锁的节点
        boolean needDeleteCurrentNode = false;

        try {
            while (!locked) {
                // 获取所有锁节点(/locker下的子节点)并排序(从小到大)
                locked = locked(getSortedChildren(), currentNode);//判断是否获取锁逻辑

                if (!locked) {
                    //获取监听节点路径逻辑
                    //前一个节点
                    String watchPath = getWatchPath(getSortedChildren(), currentNode);
                    final CountDownLatch latch = new CountDownLatch(1);
                    //监听前一个节点
                    final IZkDataListener previousNodeListener = new IZkDataListener() {

                        public void handleDataDeleted(String dataPath) throws Exception {
                            latch.countDown();//前一个删掉，等待结束
                        }

                        public void handleDataChange(String dataPath, Object data) throws Exception {

                        }
                    };

                    try {
                        client.subscribeDataChanges(watchPath, previousNodeListener);//只监听前一个节点
                        //倒计时
                        if (millisToWait != null) {
                            millisToWait -= (System.currentTimeMillis() - startMillis);
                            startMillis = System.currentTimeMillis();
                            if (millisToWait <= 0) {
                                //等待超时，放弃获取锁
                                needDeleteCurrentNode = true;
                                break;
                            }

                            latch.await(millisToWait, TimeUnit.MICROSECONDS);
                        } else {
                            latch.await();
                        }
                    } catch (ZkNoNodeException e) {
                        //TODO Rinoux:
                        e.printStackTrace();
                    } finally {
                        //超时取消订阅前一节点的消息
                        client.unsubscribeDataChanges(watchPath, previousNodeListener);
                    }

                }
            }
        } catch (LockException e) {
            //发生异常需要删除节点
            needDeleteCurrentNode = true;
            throw e;
        } catch (InterruptedException e) {
            //TODO Rinoux:
            e.printStackTrace();
        } catch (Exception e) {
            //TODO Rinoux:
            e.printStackTrace();
        } finally {
            //如果需要删除节点
            if (needDeleteCurrentNode) {
                deleteCurrentNode(currentNode);
            }
        }

        return locked;
    }

    /**
     * 根据锁名称获得序列号
     *
     * @param nodePath
     * @return
     */
    private String getLockNodeSequenceNumber(String nodePath) {
        int index = nodePath.lastIndexOf(LOCK_ID_SPLIT);
        if (index >= 0) {
            index += LOCK_ID_SPLIT.length();
            return index <= nodePath.length() ? nodePath.substring(index) : "";
        }
        return nodePath;
    }

    /**
     * 获取所有锁节点(/locker下的子节点)并排序
     *
     * @return
     * @throws Exception
     */
    private List<String> getSortedChildren() throws Exception {
        try {
            List<String> children = client.getChildren(basePath);
            Collections.sort(children, new Comparator<String>() {
                        public int compare(String lhs, String rhs) {
                            return getLockNodeSequenceNumber(lhs).compareTo(getLockNodeSequenceNumber(rhs));
                        }
                    }
            );
            return children;

        } catch (ZkNoNodeException e) {
            client.createPersistent(basePath, true);
            return getSortedChildren();

        }
    }

    protected void releaseLock(String lockPath) throws LockException {
        deleteCurrentNode(lockPath);
    }

    /**
     * 尝试获取锁
     *
     * @param timeOut
     * @param timeUnit
     * @return 锁节点的路径没有获取到锁返回null
     * @throws Exception
     */
    protected String tryAcquire(long timeOut, TimeUnit timeUnit) throws LockException {
        long startMillis = System.currentTimeMillis();
        Long millisToWait = (timeUnit != null) ? timeUnit.toMillis(timeOut) : null;

        String currentNode = null;
        boolean hasTheLock = false;
        boolean isDone = false;
        int retryCount = 0;

        //网络闪断需要重试一试
        while (!isDone) {
            isDone = true;
            try {
                // 在/locker下创建临时的顺序节点
                currentNode = createLockNode(client, path);
                System.out.println("已创建临时节点，开始判断是否获取了锁====" + currentNode);
                // 判断你自己是否获得了锁，如果没获得那么我们等待直到获取锁或者超时
                hasTheLock = waitLock(startMillis, millisToWait, currentNode);
            } catch (ZkNoNodeException e) {
                if (retryCount++ < MAX_RETRY_COUNT) {
                    isDone = false;
                } else {
                    throw e;
                }
            }
        }

        if (hasTheLock) {
            return currentNode;
        }

        return null;
    }

    private void deleteCurrentNode(String currentNode) throws LockException {
        client.delete(currentNode);
    }

    /**
     * 创建临时节点
     * @param client
     * @param path
     * @return 创建的临时节点名称
     * @throws LockException
     */
    private String createLockNode(ZkClient client, String path) throws LockException {
        // 创建临时循序节点
        return client.createEphemeralSequential(path, null);
    }

    /**
     * 释放获取锁成功
     *
     * @param children
     * @param ourPath
     * @return
     */
    public abstract boolean locked(List<String> children, String ourPath);

    /**
     * 获得前一个子节点作为监视的节点
     *
     * @param children
     * @param ourPath
     * @return
     */
    public abstract String getWatchPath(List<String> children, String ourPath);

    protected int getCurrentIndex(List<String> children, String currentNode) {
        // 获取顺序节点的名字 如:/locker/lock-0000000013 > lock-0000000013
        String sequenceNodeName = currentNode.substring(basePath.length() + 1);

        // 获取该节点在所有有序子节点位置
        int currentIndex = children.indexOf(sequenceNodeName);
        if (currentIndex < 0) {
            // 可能网络闪断 抛给上层处理
            throw new ZkNoNodeException("No such node found: " + sequenceNodeName);
        }

        return currentIndex;
    }
}


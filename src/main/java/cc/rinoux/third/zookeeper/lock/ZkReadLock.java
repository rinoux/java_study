package cc.rinoux.third.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZkReadLock extends ZkBaseLock implements Lock {
    /**
     * 锁名称前缀
     */
    public static final String LOCK_NAME = "read-lock-";

    /**
     * Zookeeper中locker节点的路径，如：/locker
     */
    private final String basePath;

    /**
     * 获取锁以后自己创建的那个顺序节点的路径
     */
    private String currentLockNode;

    public ZkReadLock(ZkClient client, String basePath) {
        super(client, basePath, LOCK_NAME);
        this.basePath = basePath;
    }

    @Override
    public void lock() throws LockException {
        // -1 表示永不超时
        currentLockNode = tryAcquire(-1, null);
        if (currentLockNode != null) {
            System.out.println("已获取到锁，节点路径名为：" + currentLockNode);
        } else {
            throw new LockException("连接丢失!在路径:'" + basePath + "'下不能获取锁!");
        }
    }

    @Override
    public boolean tryLock(long timeOut, TimeUnit timeUnit) throws LockException {
        currentLockNode = tryAcquire(timeOut, timeUnit);
        return currentLockNode != null;
    }

    @Override
    public void release() throws LockException {
        releaseLock(currentLockNode);
    }

    @Override
    public boolean locked(List<String> children, String currentNode) {
        int ourIndex = getCurrentIndex(children, currentNode);
        for (int i = 0; i < ourIndex; i++) {
            //已经有写锁，加锁失败
            if (children.get(i).contains(ZkWriteLock.LOCK_NAME))
                return false;
        }
        return true;
    }

    @Override
    public String getWatchPath(List<String> children, String currentNode) {
        int currentIndex = getCurrentIndex(children, currentNode);
        int watchIndex = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (children.get(i).contains(ZkWriteLock.LOCK_NAME))
                watchIndex = i;
        }

        String watchPath = basePath.concat("/").concat(children.get(watchIndex));
        System.out.println(Thread.currentThread().getName() + "====" + currentNode + "监听的节点为：" + watchPath);
        return watchPath;
    }

}

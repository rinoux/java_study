package cc.rinoux.third.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZkWriteLock extends ZkBaseLock implements Lock {
    /**
     * 锁名称前缀
     */
    public static final String LOCK_NAME = "write-lock-";

    /**
     * Zookeeper中locker节点的路径，如：/locker
     */
    private final String basePath;

    /**
     * 获取锁以后自己创建的那个顺序节点的路径
     */
    private String currentLockNode;

    public ZkWriteLock(ZkClient client, String basePath) {
        super(client, basePath, LOCK_NAME);
        this.basePath = basePath;
    }

    @Override
    public void lock() throws LockException {
        // -1 表示永不超时
        currentLockNode = tryAcquire(-1, null);
        if (currentLockNode != null) {
            System.out.println("已获取到锁，锁节点路径名为：" + currentLockNode);
        } else {
            throw new LockException("连接丢失!在路径:'" + basePath + "'下不能获取锁!");
        }
    }

    @Override
    public boolean tryLock(long timeOut, TimeUnit timeUnit) throws LockException {
        currentLockNode = tryAcquire(timeOut, timeUnit);
        System.out.println("获得" + this.basePath + "的锁：" + currentLockNode);
        return currentLockNode != null;
    }

    @Override
    public void release() throws LockException {
        releaseLock(currentLockNode);
    }

    @Override
    public boolean locked(List<String> children, String ourPath) {
        return getCurrentIndex(children, ourPath) == 0;
    }


    @Override
    public String getWatchPath(List<String> children, String currentPath) {
        int currentIndex = getCurrentIndex(children, currentPath);
        // 如果不是第一位,监听比自己小的那个节点的删除事件
        String pathToWatch = children.get(currentIndex - 1);
        String previousSequencePath = basePath.concat("/").concat(pathToWatch);
        System.out.println(Thread.currentThread().getName() + "====" + currentPath + "监听的节点为：" + previousSequencePath);
        return previousSequencePath;
    }
}

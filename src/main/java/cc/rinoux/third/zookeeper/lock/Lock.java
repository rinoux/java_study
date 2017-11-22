package cc.rinoux.third.zookeeper.lock;

import java.util.concurrent.TimeUnit;

public interface Lock {
    /**
     * 获取锁
     *
     * @throws LockException
     */
    void lock() throws LockException;

    /**
     * 获取锁
     *
     * @param time 超时等待时间
     * @param unit 时间单位
     * @return 是否成功
     * @throws LockException
     */
    boolean tryLock(long time, TimeUnit unit) throws LockException;

    /**
     * 释放锁
     *
     * @throws LockException
     */
    void release() throws LockException;

}

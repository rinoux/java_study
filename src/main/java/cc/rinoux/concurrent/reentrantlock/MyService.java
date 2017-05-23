package cc.rinoux.concurrent.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rinoux on 2017/2/4.
 */
public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();//这个锁的对象监视器

    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为" + System.currentTimeMillis());
            condition.await();
            //System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            //System.out.println("释放当前锁");
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

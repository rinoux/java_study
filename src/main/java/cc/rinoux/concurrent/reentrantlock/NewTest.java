package cc.rinoux.concurrent.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rinoux on 2017/2/24.
 */
public class NewTest {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() {
        lock.lock();
        System.out.println("conditionWait 获得锁");
        try {
            System.out.println("conditionWait进入等待");
            condition.await();
            System.out.println("conditionWait继续运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() {
        System.out.println("conditionSignal 获得锁");
        lock.lock();
        try {
            Thread.sleep(3000);
            condition.signal();
            System.out.println("conditionSignal已经通知");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final NewTest test =  new NewTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.conditionWait();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.conditionSignal();
            }
        }).start();

    }
}

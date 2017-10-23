package cc.rinoux.concurrent.readwritelock;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by rinoux on 2017/7/13.
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        /*
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    myQueue.get();
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    myQueue.put(new Random().nextInt(1000));
                }
            }).start();
        }*/

        int i = 1;
        System.out.println(i << 1);

    }


    static class MyQueue {
        Object data = null;
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


        public void get() {
            ReentrantReadWriteLock.ReadLock rLock = readWriteLock.readLock();
            rLock.lock();
            System.out.println(Thread.currentThread().getName() + " start loading data");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " have read data:" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rLock.unlock();
            }
        }


        public void put(Object data) {
            ReentrantReadWriteLock.WriteLock wLock = readWriteLock.writeLock();
            wLock.lock();
            System.out.println(Thread.currentThread().getName() + " start writing data");
            try {
                Thread.sleep(1000);
                this.data = data;
                System.out.println(Thread.currentThread().getName() + " have write data: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                wLock.unlock();;
            }
        }
    }

}

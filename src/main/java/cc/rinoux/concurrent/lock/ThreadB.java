package cc.rinoux.concurrent.lock;

import cc.rinoux.concurrent.locksynchronized.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2016/12/19.
 */
public class ThreadB extends Thread {
    Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        new Service().testMethod(lock);
    }


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new ThreadA(lock));
        }
        Thread.sleep(1000);
        synchronized (lock) {
            lock.notifyAll();
        }

    }
}

package cc.rinoux.concurrent.lock;

import cc.rinoux.concurrent.locksynchronized.Service;

/**
 * Created by rinoux on 2016/12/19.
 */
public class ThreadA implements Runnable {

    Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        new Service().testMethod(lock);
    }
}

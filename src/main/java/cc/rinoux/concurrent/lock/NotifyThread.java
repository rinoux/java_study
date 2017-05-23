package cc.rinoux.concurrent.lock;

import cc.rinoux.concurrent.locksynchronized.Service;

/**
 * Created by rinoux on 2016/12/22.
 */
public class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        new Service().synNotifyMethod(lock);
    }
}

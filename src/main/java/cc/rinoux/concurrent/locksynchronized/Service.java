package cc.rinoux.concurrent.locksynchronized;

/**
 * Created by rinoux on 2016/12/22.
 */
public class Service {

    public void testMethod(Object lock) {
        synchronized (lock) {
            try {
                System.out.println(this + " begin wait()");
                lock.wait();
                //Thread.sleep(5000);
                System.out.println(this + " end wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() " + Thread.currentThread().getName() + "time=" + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(3000);
                System.out.println("end notify() " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


package cc.rinoux.concurrent.reentrantlock;

/**
 * Created by rinoux on 2017/2/4.
 */
public class ThreadA extends Thread {
    public MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}

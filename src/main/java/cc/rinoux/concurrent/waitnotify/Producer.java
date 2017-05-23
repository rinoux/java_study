package cc.rinoux.concurrent.waitnotify;

/**
 * Created by rinoux on 2016/12/30.
 */
public class Producer {

    private String lock;

    public Producer(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者" + Thread.currentThread().getName() + "正在等待");
                    wait();
                }

                System.out.println("生产者" + Thread.currentThread().getName() + "执行");
                ValueObject.value = System.currentTimeMillis() + "_" + System.nanoTime();
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

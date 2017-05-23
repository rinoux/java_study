package cc.rinoux.concurrent.synchronizemechanism;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/4/13.
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(5);
    /**
     * CountDownLatch作用是设置一个计数器，构造需要一个计数量参数，
     * 当有线程调用countDownLatch.countDown()方法时，这个计数量减去1，
     * countDownLatch.await()会在计数量不为0的时候一直阻塞，直到为0时才继续执行。
     */
    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + new Date() + " run");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "执行结束后的计数值：" + countDownLatch.getCount());
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all threads run over");
    }
}

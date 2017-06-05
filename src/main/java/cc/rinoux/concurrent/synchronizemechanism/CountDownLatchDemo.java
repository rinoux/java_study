package cc.rinoux.concurrent.synchronizemechanism;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/4/13.
 */
public class CountDownLatchDemo {
    /**
     * CountDownLatch作用是设置一个计数器，构造需要一个计数量参数，
     * 当有线程调用countDownLatch.countDown()方法时，这个计数量减去1，
     * countDownLatch.await()会在计数量不为0的时候一直阻塞，直到为0时才继续执行。
     */

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + new Date() + " run");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程运行完毕！执行下一步");
    }
}

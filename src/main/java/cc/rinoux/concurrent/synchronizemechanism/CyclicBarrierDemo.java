package cc.rinoux.concurrent.synchronizemechanism;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/4/13.
 */
public class CyclicBarrierDemo {

    /**
     * A synchronization aid that allows a set of threads to all wait for
     * each other to reach a common barrier point.  CyclicBarriers are
     * useful in programs involving a fixed sized party of threads that
     * must occasionally wait for each other. The barrier is called
     * <em>cyclic</em> because it can be re-used after the waiting threads
     * are released.
     *
     * 一组线程相互等待直到达到一个公共屏障点（互相等待一起执行），再开始同步执行。
     * CyclicBarrier循环屏障之所以称为循环是因为它是可以重用的
     */
    //CyclicBarrier构造parties设置为6， 若有5个线程调用cyclicBarrier.await的话，那么这5个线程永远再等待不会执行

    public static void main(String args[]) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService pool = Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.execute(() -> {
                int secs = random.nextInt(10);
                System.out.println(Thread.currentThread().getName() + " " + new Date() + " run, sleep " + secs + " secs");
                try {
                    Thread.sleep(secs * 1000);
                    if (finalI % 2 == 0) {
                        cyclicBarrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + new Date() + " runs over");
            });
        }
    }
}

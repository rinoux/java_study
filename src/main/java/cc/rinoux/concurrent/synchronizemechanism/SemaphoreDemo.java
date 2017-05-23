package cc.rinoux.concurrent.synchronizemechanism;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by rinoux on 2017/4/13.
 */
public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(5);
    /**
     * 五个线程，信号量为5时，执行是同步的，显示时间一致
     pool-1-thread-4 Thu Apr 13 19:38:26 CST 2017
     pool-1-thread-5 Thu Apr 13 19:38:26 CST 2017
     pool-1-thread-3 Thu Apr 13 19:38:26 CST 2017
     pool-1-thread-2 Thu Apr 13 19:38:26 CST 2017
     pool-1-thread-1 Thu Apr 13 19:38:26 CST 2017
     * 信号量为2时，每次执行两个再sleep 5s
     *
     pool-1-thread-2 Thu Apr 13 19:37:30 CST 2017
     pool-1-thread-1 Thu Apr 13 19:37:30 CST 2017
     pool-1-thread-4 Thu Apr 13 19:37:35 CST 2017
     pool-1-thread-3 Thu Apr 13 19:37:35 CST 2017
     pool-1-thread-5 Thu Apr 13 19:37:40 CST 2017

     Semaphore的作用是控制获得自身线程的数量
     */
    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                try {
                    semaphore.acquire();//获得semaphore
                    System.out.println(Thread.currentThread().getName() + " " + new Date());
                    Thread.sleep(5000);
                    semaphore.release();//释放semaphore
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted");
                }
            });
        }

    }
}

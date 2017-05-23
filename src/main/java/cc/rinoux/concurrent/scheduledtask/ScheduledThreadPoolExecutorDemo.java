package cc.rinoux.concurrent.scheduledtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rinoux on 2017/5/2.
 */
public class ScheduledThreadPoolExecutorDemo {

    private static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return sdf.format(date);
    }

    /**
     * 构造方法
     ScheduledThreadPoolExecutor(int corePoolSize)
     ScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler)
     ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory)
     ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler)
     */

    ThreadFactory myThreadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread() {
                @Override
                public void run() {
                    r.run();
                }
            };
        }
    };
    //两种创建方式
    static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(4);
    ScheduledThreadPoolExecutor pool1 = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();
        Delayed delayed = new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        };
        AtomicInteger integer = new AtomicInteger();
        pool.scheduleAtFixedRate(new ScheduledTimerTask(integer), 0, 3, TimeUnit.SECONDS);//scheduleAtFixedRate重复执行任务，schedule只会执行一次
    }

    static class ScheduledTimerTask implements Runnable {
        AtomicInteger i;

        public ScheduledTimerTask(AtomicInteger i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("定时任务执行:" + i.getAndIncrement());
        }
    }
}

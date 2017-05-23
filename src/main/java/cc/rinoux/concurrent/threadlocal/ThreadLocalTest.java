package cc.rinoux.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/1/17.
 */
public class ThreadLocalTest {
    private class MyThreadLocal extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return "This is default value";
        }
    }

    MyThreadLocal threadLocal = new MyThreadLocal();

    public void setValue(String value) {
        threadLocal.set(value);
    }

    public Object getValue() {
        return threadLocal.get();
    }


    static class ThreadLRunnable implements Runnable {
        ThreadLocalTest threadLocalTest;
        String threadName;

        public ThreadLRunnable(ThreadLocalTest threadLocalTest, String name) {
            this.threadLocalTest = threadLocalTest;
            this.threadName = name;
        }

        @Override
        public void run() {
            threadLocalTest.setValue(threadName + "'s value is " + threadName);
            System.out.println(threadLocalTest.getValue());
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(new ThreadLRunnable(test, "Thread-" + i));
        }
    }
}

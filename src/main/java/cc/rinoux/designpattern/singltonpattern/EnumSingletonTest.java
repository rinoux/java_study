package cc.rinoux.designpattern.singltonpattern;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/12/5.
 */
public class EnumSingletonTest {

    private enum Singleton {

        ins;

        public static Singleton getInstance() {
            return ins;
        }

        private Object object;


        Singleton() {
            object = new Object();
        }

        public void doSth() {
            System.out.println(object);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Task(latch));
            Thread.sleep(1000);
        }


    }


    private static class Task implements Runnable {
        CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Singleton.getInstance().doSth();
        }
    }
}

package cc.rinoux.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2019/11/1
 */
public class ShutDownTest {

    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Task" + finalI + " executed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Task" + finalI + " interrupted");
                    }
                }
            });
        }


        System.out.println("Tasks submitted.");
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pool.shutdown();
                System.out.println("----Executed shutdown-----");
            }
        }).start();
    }
}

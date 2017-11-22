package cc.rinoux.concurrent.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2019/11/4
 */
public class InterruptTest {



    public static void main(String[] args) {
        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {

                    if (i == 5) {
                        Thread.currentThread().interrupt();
                    }

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Just interrupted.");
                       // break;
                    } else {
                        System.out.println("Not interrupted.");
                    }
                    System.out.println(++i);



                }
            }
        });

        a.setName("A");


        final Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

               // a.interrupt();
            }
        });

        a.setName("B");


        a.start();
        b.start();
    }


}

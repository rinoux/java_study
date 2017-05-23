package cc.rinoux.concurrent;

/**
 * Created by rinoux on 2017/2/22.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("this must be execute first");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println("this must be execute last");
        /**
         * 执行结果符合预期，原因在于，join相当于阻塞了当前线程
         */
    }


}

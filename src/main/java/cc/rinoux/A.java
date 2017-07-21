package cc.rinoux;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rinoux on 2017/7/13.
 */
public class A {

    final static A a = new A();

    static {
        System.out.println(a);
    }


    public static void main(String[] args) throws Exception {

        final ReentrantLock lock = new ReentrantLock();


        Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    lock.lock();
                    System.out.println("execute");
                    lock.unlock();
                }
            });

            lock.lock();
            lock.lock();
            t.start();

            Thread.sleep(200);
            System.out.println("realse one once");

            lock.unlock();
        }

}

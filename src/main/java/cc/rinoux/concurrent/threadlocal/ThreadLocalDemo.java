package cc.rinoux.concurrent.threadlocal;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/4/18.
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> identifier = new ThreadLocal<>();

    static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //ThreadLocalDemo demo = new ThreadLocalDemo();
            pool.execute(() -> {
                ThreadLocalDemo.identifier.set(Thread.currentThread().getName() + " " + new Date());
                System.out.println(ThreadLocalDemo.identifier.get());
            });
        }
    }
}

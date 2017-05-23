package cc.rinoux.concurrent.blockingquenes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rinoux on 2017/5/2.
 */
public class Producer implements Runnable {
    private static final int PRODUCT_PRODUCE_TIME_TAKEN = 500;
    private final BlockingQueue<Product> queue;
    private String name;
    private AtomicInteger number = new AtomicInteger();

    public Producer(BlockingQueue<Product> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {

        while (true) {
            try {
                queue.put(produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Product produce() throws InterruptedException {
        Thread.sleep(PRODUCT_PRODUCE_TIME_TAKEN);
        return new Product("No." + number.incrementAndGet() + "(" + name + ")");
    }
}

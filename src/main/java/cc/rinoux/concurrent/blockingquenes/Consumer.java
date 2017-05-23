package cc.rinoux.concurrent.blockingquenes;

import java.util.concurrent.BlockingQueue;

/**
 * Created by rinoux on 2017/5/2.
 */
public class Consumer implements Runnable {
    BlockingQueue<Product> queue;
    String name;

    public Consumer(BlockingQueue<Product> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void consume(Product product) {
        System.out.println(product.toString() + " have been consumed by " + name);
    }
}

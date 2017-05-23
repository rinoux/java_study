package cc.rinoux.concurrent.blockingquenes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rinoux on 2017/5/2.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        BlockingQueue<Product> queue = new ArrayBlockingQueue<Product>(20);

        Producer producer = new Producer(queue, "CN");
        Producer producer1 = new Producer(queue, "US");
        Consumer consumer = new Consumer(queue, "A");
        Consumer consumer1 = new Consumer(queue, "B");
        Consumer consumer2 = new Consumer(queue, "C");
        Consumer consumer3 = new Consumer(queue, "D");
        Consumer consumer4 = new Consumer(queue, "E");

        //多个生产者和消费者共同维护一个队列，同时共享队列的数据

        ExecutorService pool = Executors.newCachedThreadPool();

        pool.submit(producer);
        pool.submit(producer1);
        pool.submit(consumer);
        pool.submit(consumer1);
        pool.submit(consumer2);
        pool.submit(consumer3);
        pool.submit(consumer4);
    }
}

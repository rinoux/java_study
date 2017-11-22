package cc.rinoux.designpattern.produceconsume;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/2/19
 */
public class ExecuteProduceConsume implements Consumer, Runnable {

    Producer<Runnable> producer;

    volatile boolean pendingThread;
    AtomicBoolean producing = new AtomicBoolean(false);

    public ExecuteProduceConsume(Producer<Runnable> producer) {
        this.producer = producer;
    }

    @Override
    public void consume() {
        pendingThread = false;
        while (true) {
            //CAS，如果正处于生产状态，退出，如果是空闲状态，进入生产
            if (!producing.compareAndSet(false, true)) {
                break;
            }

            Runnable runnable;
            try {
                runnable = producer.produce();
                if (runnable != null) {
                    pendingThread = true;
                }
            } finally {
                producing.set(false);
            }

            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override
    public void run() {
        consume();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        final Random random = new Random();
        Producer<Runnable> producer = new Producer<Runnable>() {
            AtomicInteger seq = new AtomicInteger(0);

            @Override
            public Runnable produce() {
                return () -> {
                    try {
                        Thread.sleep((random.nextInt(10) + 1) * 1000L);
                        System.out.println("我是一个执行的对象" + seq.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }
        };

        for (int i = 0; i < 10; i++) {
            ExecuteProduceConsume consumer = new ExecuteProduceConsume(producer);
            executor.submit(consumer);
        }
    }
}

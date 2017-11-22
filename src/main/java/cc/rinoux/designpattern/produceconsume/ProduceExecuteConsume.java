package cc.rinoux.designpattern.produceconsume;

import java.util.concurrent.ExecutorService;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/2/19
 */
public class ProduceExecuteConsume implements Consumer {
    Producer<Runnable> producer;
    ExecutorService executor;

    @Override
    public void consume() {

        while (true) {
            Runnable runnable = producer.produce();
            if (runnable != null) {
                executor.submit(runnable);
            }
        }
    }
}

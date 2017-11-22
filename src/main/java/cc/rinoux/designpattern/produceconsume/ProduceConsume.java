package cc.rinoux.designpattern.produceconsume;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/2/19
 */
public class ProduceConsume implements Consumer {
    Producer<Runnable> producer;

    @Override
    public void consume() {

        while (true) {
            Runnable runnable = producer.produce();
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}

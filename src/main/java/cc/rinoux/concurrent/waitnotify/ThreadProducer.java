package cc.rinoux.concurrent.waitnotify;

/**
 * Created by rinoux on 2016/12/30.
 */
public class ThreadProducer extends Thread {
    private Producer producer;

    public ThreadProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            producer.setValue();
        }
    }
}

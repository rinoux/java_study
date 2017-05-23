package cc.rinoux.concurrent.waitnotify;

/**
 * Created by rinoux on 2016/12/30.
 */
public class Customer {

    private String lock;

    public Customer(String lock) {
        this.lock = lock;
    }


    public void getValue() {
        try {
            while (ValueObject.value.equals("")) {
                System.out.println("消费者" + Thread.currentThread().getName() + "没有值，等待中。。。");
                wait();
            }
            System.out.println("消费者" + Thread.currentThread().getName() + "执行");
            ValueObject.value = "";
            lock.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = "";
        Producer producer = new Producer(lock);
        Customer customer = new Customer(lock);

        ThreadProducer[] threadProducers = new ThreadProducer[2];
        ThreadCustomer[] threadCustomers = new ThreadCustomer[2];

        for (int i = 0; i < 2; i++) {
            threadProducers[i] = new ThreadProducer(producer);
            threadProducers[i].setName(" 生产者" + (i + 1));
            threadCustomers[i] = new ThreadCustomer(customer);
            threadCustomers[i].setName(" 消费者" + (i + 1));

            threadProducers[i].start();
            threadCustomers[i].start();
        }

        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);

        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }

    }
}

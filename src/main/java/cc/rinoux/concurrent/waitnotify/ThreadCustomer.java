package cc.rinoux.concurrent.waitnotify;

/**
 * Created by rinoux on 2016/12/30.
 */
public class ThreadCustomer extends Thread {
    private Customer customer;

    public ThreadCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        while (true) {
            customer.getValue();
        }
    }
}

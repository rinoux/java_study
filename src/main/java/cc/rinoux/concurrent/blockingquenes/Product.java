package cc.rinoux.concurrent.blockingquenes;

/**
 * Created by rinoux on 2017/5/2.
 */
public class Product {

    String number;

    public Product(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}

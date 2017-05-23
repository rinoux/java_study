package cc.rinoux.designpattern.factorypattern;

/**
 * Created by rinoux on 2017/4/5.
 */
public class ClientTest {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product1 = factory.createProduct1();
        Product product2 = factory.createProduct2();
        product1.show();
        product2.show();
    }
}

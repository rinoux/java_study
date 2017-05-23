package cc.rinoux.designpattern.factorypattern;

/**
 * Created by rinoux on 2017/4/5.
 */
public class ConcreteFactory implements Factory {
    @Override
    public Product1 createProduct1() {
        return new Product1();
    }

    @Override
    public Product2 createProduct2() {
        return new Product2();
    }
}

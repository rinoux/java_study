package cc.rinoux.designpattern.templatemethodpattern;

/**
 * Created by rinoux on 2017/6/5.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("放入咖啡粉");
    }

    @Override
    void addCondiments() {
        System.out.println("加糖加牛奶");
    }
}


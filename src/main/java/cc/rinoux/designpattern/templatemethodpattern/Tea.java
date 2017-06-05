package cc.rinoux.designpattern.templatemethodpattern;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("放茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("加柠檬");
    }
}

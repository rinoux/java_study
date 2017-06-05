package cc.rinoux.designpattern.templatemethodpattern;

/**
 * Created by rinoux on 2017/6/5.
 */
public class ClientDemo {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();
        coffee.prepareRecipe();
        tea.prepareRecipe();
    }
}

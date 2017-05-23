package cc.rinoux.designpattern.decoratorpattern;

import cc.rinoux.designpattern.decoratorpattern.decorated.DarkRoast;
import cc.rinoux.designpattern.decoratorpattern.decorated.Decat;
import cc.rinoux.designpattern.decoratorpattern.decorated.Espresso;
import cc.rinoux.designpattern.decoratorpattern.decorated.HouseBlend;
import cc.rinoux.designpattern.decoratorpattern.decorator.Moca;
import cc.rinoux.designpattern.decoratorpattern.decorator.Soy;
import cc.rinoux.designpattern.decoratorpattern.decorator.Whip;

/**
 * Created by rinoux on 2017/3/9.
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Moca(beverage1);
        beverage1 = new Whip(beverage1);
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Moca(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2 = new Soy(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Decat(Size.VENTI);
        beverage3 = new Moca(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        Beverage beverage4 = new Espresso(Size.GRANDE);
        beverage4 = new Whip(beverage4);
        beverage4 = new Soy(beverage4);
        System.out.println(beverage4.getDescription() + " $" + beverage4.cost());
    }
}

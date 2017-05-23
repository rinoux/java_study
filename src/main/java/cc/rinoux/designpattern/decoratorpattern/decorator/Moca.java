package cc.rinoux.designpattern.decoratorpattern.decorator;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.CondimentDecorator;

/**
 * Created by rinoux on 2017/3/9.
 */
public class Moca extends CondimentDecorator {
    Beverage beverage;

    public Moca(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Moca";
    }

    @Override
    public double cost() {
        return 2 + beverage.cost();
    }
}

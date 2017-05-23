package cc.rinoux.designpattern.decoratorpattern.decorator;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.CondimentDecorator;

/**
 * Created by rinoux on 2017/3/9.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 1.5 + beverage.cost();
    }
}

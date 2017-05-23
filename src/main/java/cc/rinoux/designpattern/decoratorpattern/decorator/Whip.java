package cc.rinoux.designpattern.decoratorpattern.decorator;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.CondimentDecorator;

/**
 * Created by rinoux on 2017/3/9.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 2.2 + beverage.cost();
    }
}

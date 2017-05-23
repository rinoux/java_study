package cc.rinoux.designpattern.decoratorpattern.decorated;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.Size;

/**
 * Created by rinoux on 2017/3/9.
 */
public class Espresso extends Beverage {
    Size size;

    public Espresso(Size size) {
        this.size = size;
        description = size.name() + " Espresso";
    }

    public Espresso() {
        size = Size.TALL;
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 26 + size.getValue();
    }
}

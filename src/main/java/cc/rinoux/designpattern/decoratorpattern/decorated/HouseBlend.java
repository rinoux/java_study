package cc.rinoux.designpattern.decoratorpattern.decorated;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.Size;

/**
 * Created by rinoux on 2017/3/9.
 */
public class HouseBlend extends Beverage{
    Size size;

    public HouseBlend(Size size) {
        this.size = size;
        description = size.name() + " HouseBlend";
    }

    public HouseBlend() {
        size = Size.TALL;
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 29 + size.getValue();
    }
}

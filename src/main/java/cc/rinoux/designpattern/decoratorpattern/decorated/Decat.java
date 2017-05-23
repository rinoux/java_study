package cc.rinoux.designpattern.decoratorpattern.decorated;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.Size;

/**
 * Created by rinoux on 2017/3/9.
 */
public class Decat extends Beverage {
    Size size;

    public Decat(Size size) {
        this.size = size;
        description = size.name() + " Decat";
    }

    public Decat() {
        size = Size.TALL;
        description = "Decat";
    }

    @Override
    public double cost() {
        return 36 + size.getValue();
    }
}

package cc.rinoux.designpattern.decoratorpattern.decorated;

import cc.rinoux.designpattern.decoratorpattern.Beverage;
import cc.rinoux.designpattern.decoratorpattern.Size;

/**
 * Created by rinoux on 2017/3/9.
 */
public class DarkRoast extends Beverage{
    Size size;

    public DarkRoast(Size size) {
        this.size = size;
        description = size.name() + " DarkRoast";
    }

    public DarkRoast() {
        this.size = Size.TALL;//默认小杯
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 27 + size.getValue();
    }
}

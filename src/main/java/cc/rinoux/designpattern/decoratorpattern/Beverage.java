package cc.rinoux.designpattern.decoratorpattern;

/**
 * 饮料类
 *
 * Created by rinoux on 2017/3/9.
 */
public abstract class Beverage {

    public String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

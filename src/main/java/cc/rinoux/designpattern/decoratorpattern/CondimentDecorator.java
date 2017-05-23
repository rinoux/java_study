package cc.rinoux.designpattern.decoratorpattern;

/**
 * 饮料的调料，继承饮料
 *
 * Created by rinoux on 2017/3/9.
 */
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();//要求实现类重写
}

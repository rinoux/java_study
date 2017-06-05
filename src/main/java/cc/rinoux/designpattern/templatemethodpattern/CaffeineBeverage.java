package cc.rinoux.designpattern.templatemethodpattern;

/**
 * Created by rinoux on 2017/6/5.
 */
public abstract class CaffeineBeverage {

    /**
     * 算法骨架，里面的方法有些是延迟实现的
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 不同的咖啡因饮料的brew和addCondiment的实现有区别，因此抽象化，延迟到具体实现类实现
     * 而烧水倒水的步骤是一样的，因此统一先实现
     */
    abstract void brew();
    abstract void addCondiments();

    private void boilWater() {
        System.out.println("烧水");
    }

    private void pourInCup() {
        System.out.println("倒水");
    }
}

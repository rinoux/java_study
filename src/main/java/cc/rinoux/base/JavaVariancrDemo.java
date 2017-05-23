package cc.rinoux.base;

/**
 * Created by rinoux on 2017/1/6.
 */
public class JavaVariancrDemo <T extends Number> {

    private T t;

    public JavaVariancrDemo(T t) {
        this.t = t;
    }

    public void print() {
        System.out.println(t.intValue());
    }
}

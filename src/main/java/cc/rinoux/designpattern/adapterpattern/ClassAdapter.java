package cc.rinoux.designpattern.adapterpattern;

/**
 * Created by rinoux on 2017/2/22.
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void doSth1() {
        super.doExtra();
    }

    @Override
    public String doSth2() {
        return null;
    }

    public static void main(String[] args) {
        Target test1 = new ClassAdapter();
        test1.doSth1();

        Target test2 = new ObjectAdapter(new Adaptee());
        test2.doSth1();
    }
}

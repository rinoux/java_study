package cc.rinoux.designpattern.adapterpattern;

/**
 * Created by rinoux on 2017/2/22.
 */
public class ObjectAdapter implements Target {
    Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void doSth1() {
        // TODO: 2017/2/22
        adaptee.doExtra();
    }

    @Override
    public String doSth2() {
        return null;
    }
}

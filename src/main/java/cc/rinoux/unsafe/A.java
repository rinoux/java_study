package cc.rinoux.unsafe;

/**
 * Created by rinoux on 2017/2/28.
 */
public class A {

    private final int num;

    public A(int num) {
        this.num = num;
        System.out.println(num);
    }

    public int getNum() {
        return num;
    }
}

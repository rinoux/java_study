package cc.rinoux.base;

import java.util.List;

/**
 * Created by rinoux on 2017/3/29.
 */
public class ObjectArray<T extends List> {
    private T[] members;
    public void create() {
        members = (T[]) new List[10];
    }


    public static void main(String[] args) {
        int a = 2, b = 2;
        a+=3;
        b=+3;
        System.out.println(a);
        System.out.println(b);
    }
}

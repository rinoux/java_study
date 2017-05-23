package cc.rinoux.base;

import java.lang.reflect.Array;

/**
 * Created by rinoux on 2016/12/28.
 */
public class IntNullDemo {

    public static void main(String[] args) {
        Integer i = null;
        System.out.println(i == null? i.intValue(): i.longValue());

        int[] list = {1, 0};

        try {
            Class c = Class.forName("java.lang.Object");
            Object array = Array.newInstance(c, 5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        list.toString();

    }
}

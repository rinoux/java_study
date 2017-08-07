package cc.rinoux;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rinoux on 2017/7/13.
 */
public final class A {


    private static String s;

    static {
        System.out.println(A.class.getClassLoader());
        s = "static";
        System.out.println(s);
    }


    public static void main(String[] args) throws Exception {
        System.out.println(A.class.getClassLoader());
        System.out.println("main");
    }
}

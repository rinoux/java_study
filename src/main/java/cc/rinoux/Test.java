package cc.rinoux;

import java.net.URL;

/**
 * Created by rinoux on 2017/7/17.
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }

    private static class AnyRef {

    }

    private static class MyAny extends AnyRef {
        public static final String s = "mmm";

    }


    private static class YouAny extends AnyRef {
        public static final String s = "yyyy";
    }
}

package cc.rinoux.base.classloader;

/**
 * Created by rinoux on 2017/1/4.
 */
public class SuperClass {
    static {
        System.out.println("Super class inited");
    }

    public static int value = 33;
    public static final String HELLO_WORLD = "hello word!";

}


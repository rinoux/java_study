package cc.rinoux.base.classloader;

public class SubClass extends SuperClass {
    static {
        System.out.println("sub class inited");
    }
}

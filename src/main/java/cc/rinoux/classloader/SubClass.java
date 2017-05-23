package cc.rinoux.classloader;

public class SubClass extends SuperClass {
    static {
        System.out.println("sub class inited");
    }
}

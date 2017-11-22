package cc.rinoux.designpattern.proxypattern.asm;

/**
 * Created by rinoux on 2017/11/16.
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }
}
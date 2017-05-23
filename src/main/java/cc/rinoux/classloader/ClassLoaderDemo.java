package cc.rinoux.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rinoux on 2017/4/21.
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream in = getClass().getResourceAsStream(fileName);
                    if (in == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("cc.rinoux.classloader.ClassLoaderDemo").newInstance();

        System.out.println(obj.getClass());
        /**
         * 这里在虚拟机中加载了两个ClassLoaderDemo类：
         * 一个是由我们自定义的ClassLoader加载；（myLoader）
         * 一个是由系统的类加载器加载。（初始加载器BootStrap ClassLoader）
         * 虽然是同一个类文件，但是由不同的类加载器加载，因此在虚拟机中属于不同的类
         */
        System.out.println(obj instanceof ClassLoaderDemo);


        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);//直接调用启动类加载器
            }
        };
        Object obj2 = classLoader.loadClass("cc.rinoux.classloader.ClassLoaderDemo").newInstance();

        System.out.println(obj2 instanceof ClassLoaderDemo);
    }
}

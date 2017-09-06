package cc.rinoux.javac;

import com.sun.tools.javac.main.Main;
import com.sun.tools.javac.parser.JavacParser;

public class CustomJavac {
    public static void main(String[] args) {
        System.out.println(compile("/Users/rinoux/GITHUB/java_study/src/main/java/cc/rinoux/javac/Morphology.java"));
    }

    /**
     * 编译类
     *
     * @param args java文件的路径
     * @return 编译结果
     */
    public static Main.Result compile(String... args) {
        //com.sun.tools.javac.main.Main
        Main compiler = new Main("javac");
        //.compile方法返回Main.Result.OK时编译成功，class文件保存在目标类的同路径下
        return compiler.compile(args);
    }

    public static void morphologyParser(String... args) {

    }
}

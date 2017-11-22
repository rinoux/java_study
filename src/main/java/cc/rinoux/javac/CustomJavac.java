package cc.rinoux.javac;

import com.sun.tools.javac.main.Main;
import com.sun.tools.javac.parser.JavacParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CustomJavac {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(compile("/Users/rinoux/GITHUB/java_study/src/main/java/cc/rinoux/javac/Morphology.java"));
    }

    /**
     * 编译类
     *
     * @param args java文件的路径
     * @return 编译结果
     */
    public static Main.Result compile(String... args) throws FileNotFoundException {
        //com.sun.tools.javac.main.Main
        PrintWriter writer = new PrintWriter(new FileOutputStream("./"));
        Main compiler = new Main("javac", writer);
        //.compile方法返回Main.Result.OK时编译成功，class文件保存在目标类的同路径下
        return compiler.compile(args);
    }

    public static void morphologyParser(String... args) {

    }
}

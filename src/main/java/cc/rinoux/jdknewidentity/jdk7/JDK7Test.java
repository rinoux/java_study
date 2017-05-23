package cc.rinoux.jdknewidentity.jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rinoux on 2017/4/1.
 */
public class JDK7Test {

    public static void main(String[] args) {
        int a = 0x11110001;//十六进制
        int b = 0b11110001;//二进制
        int c = 0123;//八进制

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * try 不需要catch，只表示包括异常抛出的表达式
     * @throws IOException
     */
    public void read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(""))){
            // TODO: 2017/4/1
        }

    }

    // 使用@SafeVarargs声明安全的变量参数抑制编译器警告
    @SafeVarargs
    public static <T> T getSome(T... args) {
        return args.length == 0?null : args[0];
    }
}


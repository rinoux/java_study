package cc.rinoux.jdknewidentity.jdk8.lamda;

import java.util.function.Consumer;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/3/11
 */
public class ConsumerTest {

    public static void main(String[] args) {

        f1("this is consumer test", ((Consumer<String>) s -> System.out.println("第一遍" + s)).andThen(s -> System.out.println("第二遍" + s)));
    }


    public static void f1(String p1, Consumer<String> consumer) {
        consumer.accept(p1.toUpperCase());
    }
}

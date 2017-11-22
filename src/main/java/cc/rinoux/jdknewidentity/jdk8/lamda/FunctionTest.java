package cc.rinoux.jdknewidentity.jdk8.lamda;

import java.util.function.Function;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/3/11
 */
public class FunctionTest {

    public static void main(String[] args) {

        System.out.println(consume("this is function test", ((Function<String, String>) String::toUpperCase).andThen(o -> o.replace(" ", ""))));

    }

    private static Object consume(String input, Function<String, String> function) {
        return function.apply(input);
    }



}

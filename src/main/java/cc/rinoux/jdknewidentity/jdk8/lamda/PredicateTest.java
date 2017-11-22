package cc.rinoux.jdknewidentity.jdk8.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/3/11
 */
public class PredicateTest {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.stream().filter(i -> i % 2 == 0);

        System.out.println(test("this is predicate test", s -> s.equals("THIS IS PREDICATE TEST")));

    }

    public static boolean test(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }
}

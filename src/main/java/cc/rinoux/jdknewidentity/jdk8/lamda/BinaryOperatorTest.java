package cc.rinoux.jdknewidentity.jdk8.lamda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/3/11
 */
public class BinaryOperatorTest {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list.stream().reduce((a, b) -> a + b));
    }
}

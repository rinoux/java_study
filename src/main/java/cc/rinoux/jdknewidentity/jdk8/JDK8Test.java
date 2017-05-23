package cc.rinoux.jdknewidentity.jdk8;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Spliterator;

/**
 * Created by rinoux on 2017/3/31.
 */
public class JDK8Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Spliterator spliterator = list.spliterator();
        spliterator.forEachRemaining(System.out::println);
        new Thread(() -> System.out.println("ssss")).start();

        Optional<JDK8Test> optional = Optional.of(new JDK8Test());
        //Object o = optional.orElse(null);


    }

    private class MYRunnable implements Runnable {

        Object param;

        public MYRunnable(Object param) {
            this.param = param;
        }

        @Override
        public void run() {
            System.out.println(param);
        }
    }
}

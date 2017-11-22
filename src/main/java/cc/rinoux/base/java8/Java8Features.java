package cc.rinoux.base.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rinoux on 2019/8/22.
 */
public class Java8Features {

    //Lambda
    static class LambdaFts {
        public static void main(String[] args) {

        }
    }

    //@FunctionalInterface注解
    static class FunctionalInterfaceAnnotation {

    }


    //stream
    static class StreamFts {


        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("fine1");
            list.add("fine2");
            list.add("fine3");
            list.add("opt4");
            list.add("opt5");
            List<String> filteredList = list.stream().filter(e -> e.contains("fine")).collect(Collectors.toList());

            filteredList.forEach(System.out::println);


            list = list.stream().map(e -> e.concat("mapped")).collect(Collectors.toList());

            list.forEach(System.out::println);

            List<Entity> entities = list.stream().map(e -> new Entity(e, 0)).collect(Collectors.toList());
            String rs = list.stream().reduce(String::concat).toString();
            //list.stream().reduce(e -> )

            System.out.println(rs);
        }
    }


    static class Entity {
        String s;
        int p;

        public Entity(String s, int p) {
            this.s = s;
            this.p = p;
        }
    }
}

package cc.rinoux.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Newfeature {

    public static void main(String[] args) {
        //map声明时赋值
        new HashMap<String, Integer>() {
            //下面是一个实例初始化块
            {
                put("1", 1);
                put("2", 2);
            }
        };


        new ArrayList<String>() {
            {
                add("1");
                add("2");
            }
        };

        //自定义的类也可以这么干,但是这样很明显有风险，可能在构造过程中就出现this逃逸了
        new Container(2) {
            {
                put("23");
                doSth();
            }
        };
    }


    public static class Container {
        List array;

        public Container(int size) {
            array = new ArrayList(size);
        }

        public void put(String t) {
            array.add(t);
        }

        public void doSth() {
            System.out.println("hello");
        }
    }
}

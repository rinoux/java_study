package cc.rinoux.collection;

import java.util.*;

/**
 * Created by rinoux on 2016/11/29.
 */
public class ListPerformanceDemo {
    /**
     *  结论：
     *
     java.util.ArrayList插入100000条数据耗时1255ms （先遍历找到下标，然后插入，然后其它元素按下标增减移动）
     java.util.LinkedList插入100000条数据耗时33ms （直接插入）
     java.util.Vector插入100000条数据耗时924ms
     java.util.Stack插入100000条数据耗时853ms
     ------------------------------------------------
     ArrayList和Vector是以数组的形式存储数据，有下标，而LinkedList则是基于链表

     java.util.ArrayList遍历100000条数据耗时3ms （直接按下标获取，速度快）
     java.util.LinkedList遍历100000条数据耗时18743ms （必须从头到尾的数下去）
     java.util.Vector遍历100000条数据耗时3ms (和ArrayList效率一样)
     java.util.Stack遍历100000条数据耗时4ms
     ------------------------------------------------
     java.util.ArrayList删除100000条数据耗时867ms
     java.util.LinkedList删除100000条数据耗时6ms (node依次移位设置本身element为空，并且设置前后节点为空)
     java.util.Vector删除100000条数据耗时872ms
     java.util.Stack删除100000条数据耗时912ms

     ArrayList／LinkedList都是线程不安全的，Vector则是同步，线程安全的

     LinkedList删除单个元素的过程是，顺着整个链表依次查找，找到元素后将其prev的next设置为本身的next，本身next的prev设置为本身的prev

     */
    static final int SUM_ITEMS = 100000;
    static final int NANO = 1000 * 1000;
    public static void main(String[] args) {


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        List<String> list3 = new Vector<>();
        List<String> list4 = new Stack<>();


        testListWriteSpeed(list1);
        testListWriteSpeed(list2);
        testListWriteSpeed(list3);
        testListWriteSpeed(list4);

        System.out.println("------------------------------------------------");



        testListReadSpeed(list1);
        testListReadSpeed(list2);
        testListReadSpeed(list3);
        testListReadSpeed(list4);

        System.out.println("------------------------------------------------");

        testListDeleteSpeed(list1);
        testListDeleteSpeed(list2);
        testListDeleteSpeed(list3);
        testListDeleteSpeed(list4);

    }


    public static void testListWriteSpeed(List list) {
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int i = 0; i < SUM_ITEMS; i++) {
            list.add(0, "the " + i + " data");
        }
        end = System.nanoTime() - start;
        System.out.println(list.getClass().getCanonicalName() + "插入" + SUM_ITEMS + "条数据耗时" + end/NANO  + "ms");
    }

    public static void testListDeleteSpeed(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < SUM_ITEMS; i++) {
            list.remove(0);
        }
        long end = System.nanoTime() - start;
        System.out.println(list.getClass().getCanonicalName() + "删除" + SUM_ITEMS + "条数据耗时" + end/NANO + "ms");

    }

    public static void testListReadSpeed(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < SUM_ITEMS; i++) {
            list.get(i);
        }
        long end = System.nanoTime() - start;
        System.out.println(list.getClass().getCanonicalName() + "遍历" + SUM_ITEMS + "条数据耗时" + end/NANO + "ms");
    }

    public static void testListUpdateSpeed(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < SUM_ITEMS; i++) {

        }
        long end = System.nanoTime() - start;
        System.out.println(list.getClass().getCanonicalName() + "获取" + SUM_ITEMS + "条数据耗时" + end/NANO + "ms");
    }
}

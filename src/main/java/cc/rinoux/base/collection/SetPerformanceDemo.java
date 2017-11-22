package cc.rinoux.base.collection;

import java.util.*;

import static cc.rinoux.base.collection.ListPerformanceDemo.SUM_ITEMS;

/**
 * Created by rinoux on 2016/11/29.
 */
public class SetPerformanceDemo {

    public static void main(String[] args) {
        /**
         * 性能差不多，HashSet和LinkedHashSet都是以hash值来决定位置（不能重复），
         * 不过LinkedHashSet需要用链表来位置插入顺序
         * 所以在插入上LinkedHashSet稍弱于HashSet
         * 在遍历上LinkedHashSet快于HashSet
         * 总体上，在没有重复元素的场景下，set的性能远好于list
         *
         * java.util.HashSet插入100000条数据耗时106ms
         java.util.LinkedHashSet插入100000条数据耗时105ms
         java.util.TreeSet插入100000条数据耗时68ms
         --------------------------------------------
         java.util.HashSet迭代100000条数据耗时12ms
         java.util.LinkedHashSet迭代100000条数据耗时4ms
         java.util.TreeSet迭代100000条数据耗时11ms
         --------------------------------------------
         java.util.HashSet删除100000条数据耗时82ms
         java.util.LinkedHashSet删除100000条数据耗时69ms
         java.util.TreeSet删除100000条数据耗时45ms
         */

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        Set<String> set3 = new TreeSet<>();

        testSetWriteSpeed(set1);
        testSetWriteSpeed(set2);
        testSetWriteSpeed(set3);

        System.out.println("--------------------------------------------");


        testSetReadSpeed(set1);
        testSetReadSpeed(set2);
        testSetReadSpeed(set3);

        System.out.println("--------------------------------------------");

        testSetRemoveSpeed(set1);
        testSetRemoveSpeed(set2);
        testSetRemoveSpeed(set3);

        System.out.println("--------------------------------------------");

        arrayPerformance();

    }

    public static void testSetWriteSpeed(Set set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            set.add("the " + i + " data");
        }
        long end = System.currentTimeMillis();
        System.out.println(set.getClass().getCanonicalName() + "插入" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");
    }

    public static void testSetReadSpeed(Set set) {
        long start = System.currentTimeMillis();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            i.next();
        }
        long end = System.currentTimeMillis();
        System.out.println(set.getClass().getCanonicalName() + "迭代" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");
    }

    public static void testSetRemoveSpeed(Set set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            set.remove("the " + i + " data");
        }
        long end = System.currentTimeMillis();
        System.out.println(set.getClass().getCanonicalName() + "删除" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");
    }

    public static void arrayPerformance() {
        String[] strings = new String[SUM_ITEMS];
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            strings[i] = "the " + i + " data";
        }
        long end = System.currentTimeMillis();
        System.out.println("String[]遍历修改" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");

    }
}

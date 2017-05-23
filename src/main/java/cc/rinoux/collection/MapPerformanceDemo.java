package cc.rinoux.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rinoux on 2016/11/29.
 */
public class MapPerformanceDemo {

    private static final int SUM_ITEMS = 1000000;


    public static void main(String[] args) {
        /**
         *
         *
         * java.util.HashMap插入100000条数据耗时137ms
         java.util.Hashtable插入100000条数据耗时53ms
         java.util.TreeMap插入100000条数据耗时114ms
         java.util.LinkedHashMap插入100000条数据耗时50ms
         java.util.WeakHashMap插入100000条数据耗时60ms
         ------------------------------------------------
         java.util.HashMap遍历100000条数据耗时468ms（遍历次数多的时候很耗时，每次都是从新遍历）
         java.util.Hashtable遍历100000条数据耗时29ms
         java.util.TreeMap遍历100000条数据耗时34ms
         java.util.LinkedHashMap遍历100000条数据耗时10ms （因为保存了顺序，遍历时依次查找）
         java.util.WeakHashMap遍历100000条数据耗时32ms
         ------------------------------------------------
         java.util.HashMap删除100000条数据耗时31ms
         java.util.Hashtable删除100000条数据耗时33ms
         java.util.TreeMap删除100000条数据耗时60ms
         java.util.LinkedHashMap删除100000条数据耗时24ms
         java.util.WeakHashMap删除100000条数据耗时8ms
         */
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new Hashtable<>();
        Map<String, String> map3 = new TreeMap<>();
        Map<String, String> map4 = new LinkedHashMap<>();
        Map<String, String> map5 = new WeakHashMap<>();
        Map<String, String> map6 = new ConcurrentHashMap<>();//多线程情况下表现最好

        testMapWriteSpeed(map1);
        testMapWriteSpeed(map2);
        testMapWriteSpeed(map3);
        testMapWriteSpeed(map4);
        testMapWriteSpeed(map5);
        testMapWriteSpeed(map6);

        System.out.println("------------------------------------------------");

        testMapReadSpeed(map1);
        testMapReadSpeed(map2);
        testMapReadSpeed(map3);
        testMapReadSpeed(map4);
        testMapReadSpeed(map5);
        testMapReadSpeed(map6);
        System.out.println("------------------------------------------------");

        testMapRemoveSpeed(map1);
        testMapRemoveSpeed(map2);
        testMapRemoveSpeed(map3);
        testMapRemoveSpeed(map4);
        testMapRemoveSpeed(map5);
        testMapRemoveSpeed(map6);

    }

    public static void testMapWriteSpeed(Map map) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            map.put("data" + i, "the " + i + " data");
        }
        long end = System.currentTimeMillis();
        System.out.println(map.getClass().getCanonicalName() + "插入" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");

    }

    public static void testMapReadSpeed(Map map) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            map.get("data" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println(map.getClass().getCanonicalName() + "遍历" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");

    }

    public static void testMapRemoveSpeed(Map map) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SUM_ITEMS; i++) {
            map.remove("data" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println(map.getClass().getCanonicalName() + "删除" + SUM_ITEMS + "条数据耗时" + (end - start)  + "ms");

    }
}

package cc.rinoux.base.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rinoux on 2017/1/9.
 */
public class LHMapAttriDemo {

    public static void main(String[] args) {
        Map<String, String> testMap = new LinkedHashMap<>();

        for (int i = 0; i < 1000000; i++) {
            testMap.put("key" + i, "value" + i);
        }

        long start = System.nanoTime();
        System.out.println(testMap.get("key0"));
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}

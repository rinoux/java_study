package cc.rinoux.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rinoux on 2017/2/27.
 */
public class OtherTests {

    private static final int SUM = 1000000;
    private static final int NANO = 1000 * 1000;

    @Test
    public void testSetToArraySpeed() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < SUM; i++) {
            set.add("set elem" + i);
        }
        String[] array = new String[set.size()];
        long t = System.nanoTime();
        set.toArray(array);
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
        }
        long total = System.nanoTime() - t;
        System.out.println(total / NANO + "ms");
    }

    @Test
    public void testMapRemove() {

        Map map = new HashMap();
        map.put("key", "value");
        System.out.println(map.remove("key"));

    }
}

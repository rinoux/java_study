package cc.rinoux.om;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rinoux on 2017/5/26.
 */
public class HeapOutOfMemoryDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(10000_0000);
        for (int i = 0; i < list.size(); i++) {
            list.add(String.valueOf(i));
        }

        List l = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (Object o : l) {
            System.out.println(o.toString());
        }
    }
}

package cc.rinoux.reflect;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by rinoux on 2018/3/8.
 */
public class GenericTypeTest {

    Cool<VIX> vixCool;

    public static void main(String[] args) {

        Field[] fields = GenericTypeTest.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            System.out.println(name);

            System.out.println(field.getGenericType());
        }
    }


    private class Cool<T> {
        T v;
    }


    private class VIX {
        String vix;

        public VIX(String vix) {
            this.vix = vix;
        }
    }
}

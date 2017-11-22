package cc.rinoux.base.annotations;

import java.lang.reflect.Field;

/**
 * Created by rinoux on 2017/3/15.
 */
public class AnnotationTest {
    public String pluginName;


    public static void main(String[] args) {
        try {
            Field field = AnnotationTest.class.getDeclaredField("pluginName");
            if (field.isAnnotationPresent(Plugin.class)) {
                System.out.println(field.getAnnotation(Plugin.class).type());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}

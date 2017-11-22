package cc.rinoux.base;

import java.lang.reflect.Field;

/**
 * Created by rinoux on 2018/1/30.
 */
public class Constants {


    public static void main(String[] args) {
        Object[] objects = Constants.getAll(NAMES.class);
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    public static class NAMES {
        public static final String FILE_SYSTEM = "FileSystem";
        public static final String FTP  = "FTP";

    }




    public static class VALUES {
        public static final int KB = 1024;
        public static final int TEN_KB = KB * 1024;

        public static Object[] getAll() {
            return Constants.getAll(VALUES.class);
        }
    }



    private static Object[] getAll(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Object[] res = new Object[fields.length];

        try {
            for (int i = 0; i < fields.length; i++) {

                Field field = fields[i];
                field.setAccessible(true);
                Class<?> typeClass = field.getType();
                res[i] = field.get(typeClass);
            }
        } catch (IllegalAccessException e) {
            //
        }


        return res;
    }
}

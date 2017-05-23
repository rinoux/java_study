package cc.rinoux.base.immutable;

import java.lang.reflect.Field;

/**
 * Created by rinoux on 2016/11/28.
 */
public class StringFinalDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        final String s1 = new String("this is string s1");
        final String s2 = s1 + " appended s2";
        final StringBuilder sb1 = new StringBuilder("this is string s1");
        final StringBuilder sb2 = sb1.append(" appended s2");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());

        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        class1 = Class.forName("cc.rinoux.base.immutable.StringFinalDemo");
        class2 = new StringFinalDemo().getClass();
        class3 = StringFinalDemo.class;
        //System.out.println("类名称   " + class1.getName());
        //System.out.println("类名称   " + class2.getName());
       // System.out.println("类名称   " + class3.getName());

        Field chars = class1.getDeclaredField("value");
        chars.setAccessible(true);

        System.out.println(chars);



    }



}

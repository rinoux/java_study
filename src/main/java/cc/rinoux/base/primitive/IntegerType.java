package cc.rinoux.base.primitive;

public class IntegerType {
    public static void main(String[] args) {
        Class<Integer> a = int.class;
        Class<Integer> b = Integer.TYPE;//(Class<Integer>) Class.getPrimitiveClass("int");
        Class<Integer> c = Integer.class;


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

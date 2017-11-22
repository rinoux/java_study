package cc.rinoux.base.collection;

/**
 * Created by rinoux on 2016/12/20.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        int n = 16;

        int hash1 = obj1.hashCode();
        int hash2 = obj2.hashCode();


        System.out.println(5 >> 1);

    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

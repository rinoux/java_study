package cc.rinoux.unsafe;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by rinoux on 2017/2/28.
 */
public class UnsafeUtils<T> {
    public Object getUnsafeAllocIns(Class<T> tClass) {
        if (tClass != null) {
            try {
                return getUnsafe().allocateInstance(tClass);
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获得unsafe对象
     * @return
     */
    public static Unsafe getUnsafe() {
        try {
            Field singletonInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singletonInstanceField.setAccessible(true);
            return (Unsafe) singletonInstanceField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转化成地址
     * @param obj
     * @return
     */
    private static long toAddress(Object obj) {
        Object[] objects = new Object[]{obj};
        long baseOffset = getUnsafe().arrayBaseOffset(objects.getClass());
        return normalize(getUnsafe().getInt(objects, baseOffset));
    }

    /**
     * 将地址转化成对象
     * @param address
     * @return
     */
    private static Object fromAddress(long address) {
        Object[] objects = new Object[]{null};
        long baseOffset = getUnsafe().arrayBaseOffset(objects.getClass());
        getUnsafe().putLong(objects, baseOffset, address);
        return objects[0];
    }

    private static long normalize(int value) {
        if (value > 0) {
            return value;
        }
        return (~0L >>> 32) & value;
    }

    public static Object shallowCopy(Object obj) {
        long size = sizeOf(obj);//对象所需内存大小
        long start = toAddress(obj); //对象的地址起始偏移量
        long address = getUnsafe().allocateMemory(size);//分配size大小的内存，返回内存空间地址偏移量，准备放入复制的对象
        getUnsafe().copyMemory(start, address, size);//从对象地址起始偏移量开始复制内存到address开始的内存
        return fromAddress(address);//将地址转化成对象
    }

    public static long sizeOf(Object obj) {
        return getUnsafe().getAddress(normalize(getUnsafe().getInt(obj, 4L)) + 12L);
    }

    public static void main(String[] args) throws InstantiationException, NoSuchFieldException {
        Unsafe unsafe = getUnsafe();
        final Class aClass = A.class;
        A a = (A) unsafe.allocateInstance(aClass);
        System.out.println(a.getNum());

        A a1 = new A(12);
        Field f = a1.getClass().getDeclaredField("num");
        unsafe.putInt(a1, unsafe.objectFieldOffset(f), 8);
        System.out.println(a1.getNum());

        unsafe.throwException(new IOException());

    }

}

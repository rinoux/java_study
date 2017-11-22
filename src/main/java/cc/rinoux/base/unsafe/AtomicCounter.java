package cc.rinoux.base.unsafe;

import sun.misc.Unsafe;

/**
 * 一个原子操作的计时器类，仿照atomic包里的类
 * Created by rinoux on 2017/3/1.
 */
public class AtomicCounter implements Counter{
    private volatile long counter = 0;
    private Unsafe unsafe;
    private long offset;

    public AtomicCounter() throws NoSuchFieldException {
        unsafe = UnsafeUtils.getUnsafe();
        //获得counter的地址偏移量
        offset = unsafe.objectFieldOffset(AtomicCounter.class.getDeclaredField("counter"));
    }


    @Override
    public void increment() {
        long before = counter;
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            before = counter;
        }
    }

    @Override
    public long getCounter() {
        return this.counter;
    }
}

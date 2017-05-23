package cc.rinoux.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by rinoux on 2017/3/22.
 */
public class ReferenceTest {
    public static void main(String[] args) throws Exception {
        String str = "This is soft reference test string";
        ReferenceQueue<String> queue = new ReferenceQueue<>();


        //软引用
        SoftReference<String> sr = new SoftReference<String>(str, queue);
        //弱引用
        WeakReference<String> wr = new WeakReference<String>(str, queue);

        PhantomReference<String> pr = new PhantomReference<>(str, queue);
        //FinalReference不让用
        System.out.println("sr before gc: " + sr.get());
        System.out.println("wr before gc: " + wr.get());
        str = null;

        System.gc();
        System.out.println("sr after gc: " + sr.get());
        System.out.println("wr after gc: " + wr.get());

        System.out.println(queue.poll());

        ReferenceTest.soft();
    }

    public static void soft() throws Exception {
        Object obj = new Object();
        ReferenceQueue refQueue = new ReferenceQueue();
        SoftReference softRef = new SoftReference(obj, refQueue);
        System.out.println(softRef.get());
        System.out.println(refQueue.poll());
        obj = null;
        System.gc();
        System.out.println(softRef.get());
        Thread.sleep(200);
        System.out.println(refQueue.poll()); }
}

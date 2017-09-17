package cc.rinoux.concurrent.thread;

import java.util.Vector;

public class ThreadSafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        //在java8 jvm不会出现异常，怀疑已经优化了
                        //如果此时removeThread删除了一个元素，下面的打印语句是无法感知的vector.size() - 1的变化，会出现ArrayIndexOutOfBoundsException
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();


            while (Thread.activeCount() > 20);
        }
    }

    /**
     * 这段程序会出现ArrayIndexOutOfBoundsException，尽管vector的remove，get，size方法都是加了synchronized
     *
     Exception in thread "Thread-47857" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 9
     at java.util.Vector.get(Vector.java:748)
     at cc.rinoux.concurrent.thread.ThreadSafe$2.run(ThreadSafe.java:27)
     at java.lang.Thread.run(Thread.java:745)
     */
}

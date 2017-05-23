package cc.rinoux.concurrent.synchronizemechanism;

/**
 * Created by rinoux on 2016/11/25.
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }




    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        new Thread(new MyThread(demo)).start();
        new Thread(new MyThread(demo)).start();
        new Thread(new MyThread(demo)).start();
        new Thread(new MyThread(demo)).start();
        new Thread(new MyThread(demo)).start();

        /**
         * 在ThreadLocal类中有一个Map，用于存储每一个线程的变量副本，Map中元素的键为线程对象，而值对应线程的变量副本
         * ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。因为每一个线程都拥有自己的变量副本，
         * 从而也就没有必要对该变量进行同步了。ThreadLocal提供了线程安全的共享对象，在编写多线程代码时，
         * 可以把不安全的变量封装进ThreadLocal。
         * 打印结果：
         *
         Thread-1 running by 1
         Thread-0 running by 1
         Thread-0 running by 2
         Thread-0 running by 3
         Thread-2 running by 1
         Thread-1 running by 2
         Thread-1 running by 3
         Thread-2 running by 2
         Thread-2 running by 3
         Thread-3 running by 1
         Thread-3 running by 2
         Thread-3 running by 3
         Thread-4 running by 1
         Thread-4 running by 2
         Thread-4 running by 3
         */
    }


    static class MyThread implements Runnable {

        ThreadLocalDemo num;


        public MyThread(ThreadLocalDemo num) {
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " running by " + num.getNextNum());
            }
        }
    }


}

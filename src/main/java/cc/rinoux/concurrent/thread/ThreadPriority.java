package cc.rinoux.concurrent.thread;

public class ThreadPriority {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.setPriority(Thread.MIN_PRIORITY);
        t.setPriority(Thread.MAX_PRIORITY);
        t.setPriority(2);//1-10的数字



    }
}

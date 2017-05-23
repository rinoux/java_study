package cc.rinoux.concurrent;

/**
 * Created by rinoux on 2017/2/28.
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ReaderThread().start();
        }

        number = 42;
        ready = true;
    }
}

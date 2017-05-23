package cc.rinoux.base.intervalTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by rinoux on 2016/12/15.
 */
public class TimerTaskDemo {

    private static class MyTimerTask extends TimerTask {

        static int i = 0;
        @Override
        public void run() {

            System.out.println("this is " + i + " task period");
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 0, 1000);

        System.out.println("进行实际任务。。。");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(3000);
            //System.out.println("timer is working");
        }

        System.out.println("实际任务完成");

        timer.cancel();
    }
}

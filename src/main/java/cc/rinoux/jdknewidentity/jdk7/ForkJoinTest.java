package cc.rinoux.jdknewidentity.jdk7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by rinoux on 2017/4/1.
 */
public class ForkJoinTest {
    /**
     * 所谓ForkJoin就是先Fork再Join，先将任务分成多个小任务然后将各自执行的结果合并得到结果
     */

    public static void main(String[] args) {
        ForkJoinPool pool1 = new ForkJoinPool(10);
        ForkJoinPool pool2 = new ForkJoinPool();

        ForkJoinTask task = new ForkJoinTask() {
            @Override
            public Object getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }
        };
    }
}

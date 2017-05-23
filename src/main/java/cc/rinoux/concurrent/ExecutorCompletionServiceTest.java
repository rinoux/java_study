package cc.rinoux.concurrent;

import java.util.concurrent.*;

/**
 * Created by rinoux on 2017/4/18.
 */
public class ExecutorCompletionServiceTest {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        Executor ex= Executors.newCachedThreadPool();
        CompletionService<Long> cs = new ExecutorCompletionService<Long>(ex);
        cs.submit(new Worker());
        cs.submit(new Worker());
        cs.submit(new Worker());
        for(int i=0;i<3;i++){
            long l=cs.take().get();
            //utilize the result
            System.out.println(l);
        }
    }
}
class Worker implements Callable{
    @Override
    public Long call() throws Exception {
        //do some task and return back
        return System.currentTimeMillis();
    }

}

package cc.rinoux.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by rinoux on 2017/4/18.
 */
public class ExecutorCompletionServiceTest {
    //多个任务一起执行，然后统一依次通过ExecutorCompletionService.take来获得结果
    //这样可以取代多个future各自取结果
    public static void main(String... args) throws InterruptedException, ExecutionException {
        Executor ex = Executors.newCachedThreadPool();
        CompletionService<String> cs = new ExecutorCompletionService<>(ex);
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            results.add(cs.submit(new MyTask()));
        }
        //使用future
        for (int i = 0; i < 3; i++) {
            String res = results.get(i).get();
            System.out.println(res);
        }
        //使用ExecutorCompletionService特性
        for (int i = 0; i < 3; i++) {
            String res = cs.take().get();
            System.out.println(res);
        }
    }
}


class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return System.currentTimeMillis() + Thread.currentThread().getName() + "执行完成";
    }
}

package cc.rinoux.base.file.commonio;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class FileWatcher {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/rinoux/common");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        while (in.read(b) > 0) {
            System.out.println("not null");
            System.out.println(new String(b));
        }
        long interval = TimeUnit.SECONDS.toMillis(5);
        //观察路径并过滤变化的文件类型
        //FileAlterationObserver observer = new FileAlterationObserver(file, FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".txt")));
        FileAlterationObserver observer = new FileAlterationObserver(file, pathname -> !pathname.getName().equals(".DS_Store"));
        //observer观察到的事件通知FileAlterationListener处理
        observer.addListener(new CustomFileAlterationListener());
        //monitor监视器调度observer
        //可以加多个observer,monitor会开一个线程轮询observer.checkAndNotify();
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);

        monitor.start();

    }
}

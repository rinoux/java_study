package cc.rinoux.concurrent.filelock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

public class FileLockTest {
    public static final String LOG_FILE_NAME = "logfile.txt";

    public static void main(String[] args) {
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        FileChannel channel = null;
        FileLock fileLock = null;
        try {
            //channel = new FileOutputStream(LOG_FILE_NAME, true).getChannel();
            //访问模式可以是只读r、读写rw（以及文件头底层同步读写rws、底层同步读写rwd），
            // 一般就是r和rw
            RandomAccessFile raf = new RandomAccessFile(LOG_FILE_NAME, "rw");

            //seek: Sets the file-pointer offset 设置文件指针位移（在文件中移动读写起点）
            raf.seek(raf.length());
            channel = raf.getChannel();


            //第三个参数是文件锁是否共享，若系统不支持，将会采用排他锁
            //fileLock = channel.lock(0L, Long.MAX_VALUE, true);
            fileLock = channel.lock();
            System.out.println("当前锁类型：" + (fileLock.isShared() ? "共享锁" : "排他锁"));
            System.out.println(System.currentTimeMillis() + " 进程:" + pid + "获得了锁" + fileLock.toString());

            ByteBuffer sendBuffer = ByteBuffer.wrap((pid + ": " + new Date() + "写入\n").getBytes());
            channel.write(sendBuffer);
            Thread.sleep(10000);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fileLock != null) {
                try {
                    fileLock.release();
                    System.out.println(System.currentTimeMillis() + " 进程:" + pid + "释放锁");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

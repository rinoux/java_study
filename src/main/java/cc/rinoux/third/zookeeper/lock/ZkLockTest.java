package cc.rinoux.third.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZkLockTest {
    /*
    在zookeeper中只是保存这个文件映射的zkNode并不是实际上的文件
    这个思路可以不限于我们要进行加锁的资源的格式、存储介质，只需要使用路径的标准限定名称
    同理，使用其它锁比如进程间的FileLock，也可以这样，不直接对资源加锁，而是映射到本地的File
    访问的时候先检查本地的映射File的锁达到控制读写的目的
      */
    static String fileToLock = "/Users/rinoux/Desktop/test.txt";
    static String servers = "127.0.0.1:2181";
    public static class NodeCreator {
        public static void main(String[] args) {
            ZkClient zkClient = new ZkClient(servers, 5000, 5000, new BytesPushThroughSerializer());

            zkClient.createPersistent(fileToLock, true);
            List<String> children = zkClient.getChildren("/Users/rinoux/Desktop/test.txt");
            for (String child : children) {
                System.out.println(child);
            }
        }
    }

    /**
     * 启动多个ProcessLockTest测试进程间锁
     */
    public static class ProcessWriteLockTest {
        public static void main(String[] args) {
            String PID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            ZkClient client = new ZkClient(servers, 5000, 5000, new BytesPushThroughSerializer());
            ZkWriteLock writeLock = new ZkWriteLock(client, fileToLock);
            try {
                boolean locked = writeLock.tryLock(5000, TimeUnit.MILLISECONDS);
                if (locked) {
                    System.out.println(PID + " Get the lock of " + fileToLock);
                }

                File file = new File(fileToLock);
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                raf.seek(raf.length());
                byte[] msg = ("Process:" + PID + " write message, --" + System.currentTimeMillis() + "\n").getBytes();
                raf.write(msg);
                Thread.sleep(10000);
                raf.close();

            } catch (LockException | IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    writeLock.release();
                    System.out.println(PID + "release the lock success!");
                } catch (LockException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class ProcessReadLockTest {
        public static void main(String[] args) {
            String PID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            ZkClient client = new ZkClient(servers, 5000, 5000, new BytesPushThroughSerializer());
            ZkReadLock readLock = new ZkReadLock(client, fileToLock);
            try {
                boolean locked = readLock.tryLock(5000, TimeUnit.MILLISECONDS);
                if (locked) {
                    System.out.println(PID + " Get the lock of " + fileToLock);
                }

                File file = new File(fileToLock);
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                while (fis.read(buffer) > 0) {
                    System.out.println(new String(buffer));
                }
                Thread.sleep(10000);

                fis.close();


            } catch (LockException | IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    readLock.release();
                    System.out.println(PID + "release the lock success!");
                } catch (LockException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

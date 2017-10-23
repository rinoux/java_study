package cc.rinoux.zookeeper.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTestLock {

    private static String basepath = "/locker";

    /** 启动的服务个数 */
    private static final int CLIENT_QTY = 3;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static{

        ZkClient zkclient = new ZkClient("127.0.0.1:2181", 500000, 500000, new SerializableSerializer());
        zkclient.createPersistent(basepath,true);
    }

    public static class ThreadDemo extends Thread {

        private Lock lock;

        private String name;

        public ThreadDemo(String name,Lock lock){
            this.lock = lock;
            this.name = name;
            setName(name);
        }
        @Override
        public void run(){
            try {
                lock.lock();
//				System.out.println(name+" is get lock!");
                // 5s 后lock1释放锁
                System.out.println(name+" is sleeping 5s");
                Thread.sleep(5000);
                lock.release();
                System.out.println(name+" is released lock");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        for(int i=0;i<CLIENT_QTY;i++){
            ZkClient zkClient4 = new ZkClient("127.0.0.1:2181", 5000, 5000, new BytesPushThroughSerializer());
            ZkWriteLock lock4 = new ZkWriteLock(zkClient4, basepath);
            exec.submit(new ThreadDemo("Thread-Write-"+i, lock4));
        }

        for(int i=0;i<CLIENT_QTY;i++){
            ZkClient zkClient4 = new ZkClient("127.0.0.1:2181", 5000, 5000, new BytesPushThroughSerializer());
            ZkReadLock lock4 = new ZkReadLock(zkClient4, basepath);
            exec.submit(new ThreadDemo("Thread-Read-"+i, lock4));
        }

    }

}


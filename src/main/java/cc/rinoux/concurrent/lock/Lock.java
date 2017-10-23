package cc.rinoux.concurrent.lock;

/**
 * 使用同步和对象锁实现的可重入锁和不可重入锁
 */
public class Lock {
    public static class UnReentrantLock {
        private boolean isLocked = false;
        public synchronized void lock() throws InterruptedException {
            while(isLocked){
                wait();
            }
            isLocked = true;
        }
        public synchronized void unlock(){
            isLocked = false;
            notify();
        }
    }

    public static class ReentrantLock {
        private boolean isLocked = false;
        private Thread lockOwner = null;
        private int count = 0;
        public synchronized void lock() throws InterruptedException {
            Thread currentThread = Thread.currentThread();
            while (isLocked && currentThread != lockOwner) {
                this.wait();
            }
            isLocked = true;
            count++;
            lockOwner = Thread.currentThread();
        }

        public synchronized void unlock() {
            if (Thread.currentThread() == lockOwner) {
                count--;
                if (count == 0) {
                    isLocked = false;
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Lock.ReentrantLock unReentrantLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    unReentrantLock.lock();
                    System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + "开始执行。。。");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    unReentrantLock.unlock();
                }

            }).start();
        }
    }
}

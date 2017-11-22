package cc.rinoux.third.zookeeper.lock;

public class LockException extends Exception{
    String message;
    public LockException() {
        super();
    }

    public LockException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

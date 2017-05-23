package cc.rinoux.base;

/**
 * Created by rinoux on 2017/2/23.
 */
public enum Status {
    OPEN(1), CLOSE(2), OTHER(3);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

class Test {
    public static void main(String[] args) {
        Status status = Status.CLOSE;
        if (status == Status.CLOSE) {
            System.out.println(status.getCode());
        }

        switch (status) {
            case CLOSE:
                //
                break;
            case OPEN:
                //
                break;
            case OTHER:
                //
                break;
            default:
                break;
        }
    }
}

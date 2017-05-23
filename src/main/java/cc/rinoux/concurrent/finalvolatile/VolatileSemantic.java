package cc.rinoux.concurrent.finalvolatile;

/**
 * Created by rinoux on 2017/3/2.
 */
public class VolatileSemantic {
    private volatile int count = 0;

    static VolatileSemantic volatileSemantic;

    public VolatileSemantic() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public static void writer() {
        volatileSemantic = new VolatileSemantic();
    }
    public static void reader() {
        VolatileSemantic vs = volatileSemantic;
        vs.getCount();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                VolatileSemantic.reader();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                VolatileSemantic.writer();
            }
        }).start();
    }
}

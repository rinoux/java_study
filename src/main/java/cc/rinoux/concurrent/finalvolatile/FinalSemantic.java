package cc.rinoux.concurrent.finalvolatile;

/**
 * Created by rinoux on 2017/3/2.
 */
public class FinalSemantic {
    int i;
    final int j;

    static FinalSemantic obj;

    public FinalSemantic() {
        this.i = 1;
        this.j = 2;
    }

    public static void writer() {
        obj = new FinalSemantic();
    }

    public static void reader() {
        FinalSemantic object = obj;
        int a = object.i;
        int b = object.j;
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalSemantic.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalSemantic.reader();
            }
        }).start();
    }

}

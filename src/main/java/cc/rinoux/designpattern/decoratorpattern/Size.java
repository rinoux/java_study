package cc.rinoux.designpattern.decoratorpattern;

/**
 * Created by rinoux on 2017/3/9.
 */
public enum Size {
    TALL, GRANDE, VENTI;

    public double getValue() {
        switch (this) {
            case TALL: return 0;
            case GRANDE: return 5.0;
            case VENTI: return 8.0;
            default: return 0;
        }
    }
}

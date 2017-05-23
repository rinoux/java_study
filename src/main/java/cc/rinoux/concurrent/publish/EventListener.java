package cc.rinoux.concurrent.publish;


/**
 * Created by rinoux on 2017/3/6.
 */
public interface EventListener {
    void onEvent(Event e);
}

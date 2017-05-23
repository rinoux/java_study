package cc.rinoux.concurrent.publish;


/**
 * Created by rinoux on 2017/3/6.
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                //
            }
        });
    }
}

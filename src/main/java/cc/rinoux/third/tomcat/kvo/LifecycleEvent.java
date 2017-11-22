package cc.rinoux.third.tomcat.kvo;

import java.util.EventObject;

public class LifecycleEvent extends EventObject{
    private Lifecycle lifecycle = null;
    private Object data = null;
    private String type = null;

    public LifecycleEvent(Lifecycle lifecycle, Object data, String type) {
        super(lifecycle);
        this.lifecycle = lifecycle;
        this.data = data;
        this.type = type;
    }

    public LifecycleEvent(Lifecycle lifecycle, String type) {
        this(lifecycle, null, type);
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }
}

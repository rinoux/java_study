package cc.rinoux.tomcat.kvo;

public class LifecycleSupport {
    private Lifecycle lifecycle;
    private LifecycleListener[] listeners = new LifecycleListener[0];
    public LifecycleSupport(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public void addLifecycleListener(LifecycleListener listener) {
        synchronized (listeners) {
            //用新建数组代替原来的实现自动扩容
            LifecycleListener[] update = new LifecycleListener[listeners.length + 1];
            for (int i = 0; i < listeners.length; i++) {
                update[i] = listeners[i];
            }
            update[listeners.length] = listener;
            listeners = update;
        }
    }

    public LifecycleListener[] findLifecycleListeners() {
        return listeners;
    }

    public void fireLifecycleEvent(String type, Object data) {
        LifecycleEvent event = new LifecycleEvent(lifecycle, data, type);
        LifecycleListener[] interested = null;
        synchronized (listeners) {
            interested = listeners.clone();
        }

        for (int i = 0; i < interested.length; i++) {
            interested[i].lifecycleEvent(event);
        }
    }


    public void removeLifecycleListener(LifecycleListener listener) {
        int n = -1;
        synchronized (listeners) {
            for (int i = 0; i < listeners.length; i++) {
                if (listeners[i] == listener) {
                    n = i;
                    break;
                }
            }

            if (n < 0) {
                return;
            }
            LifecycleListener[] update = new LifecycleListener[listeners.length - 1];
            for (int i = 0, j = 0; i < listeners.length; i++) {
                if (i != n) {
                    update[j++] = listeners[i];
                }
            }

            listeners = update;
        }
    }
}

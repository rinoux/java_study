package cc.rinoux.third.tomcat.kvo;

public class ConcreteLifecycleObject implements Lifecycle {

    LifecycleSupport support = new LifecycleSupport(this);
    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        support.addLifecycleListener(listener);
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        support.removeLifecycleListener(listener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return support.findLifecycleListeners();
    }

    @Override
    public void start() throws LifecycleException {
        support.fireLifecycleEvent(Lifecycle.BEFORE_START_EVENT, null);
    }

    @Override
    public void stop() throws LifecycleException {

    }
}

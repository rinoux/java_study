package cc.rinoux.third.tomcat.kvo;

public interface Lifecycle {
    //事件名称
    String START_EVENT = "start";
    String BEFORE_START_EVENT = "before_start";
    String AFTER_START_EVENT = "after_start";
    String STOP_EVENT = "stop";
    String BEFORE_STOP_EVENT = "before_stop";
    String AFTER_STOP_EVENT = "after_stop";

    //添加删除观察者
    void addLifecycleListener(LifecycleListener listener);
    void removeLifecycleListener(LifecycleListener listener);
    LifecycleListener[] findLifecycleListeners();

    //主动启动和停止
    void start() throws LifecycleException;
    void stop() throws LifecycleException;

}


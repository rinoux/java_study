package com.fr.decision.staticres.monitor;

/**
 * 对某个path的观察对象
 *
 * 能够添加删除获取该path的Listener
 *
 * Listener需要过滤的内容
 *
 * 检查path内文件的变动通知Listener
 *
 */
public interface FileModificationObserver {
    Object getDirectory();
    Object getFileFilter();
    void addListener();
    void removeListener();
    Iterable getListeners();
    void checkAndNotify();//需要重载几个不同参数比较文件的具体变化
}

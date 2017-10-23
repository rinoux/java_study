package com.fr.decision.staticres.monitor;


/**
 * 实际的监控者，可以加入多个FileModificationObserver， 使用单独的线程进行进行定时调用observer监控
 *
 */
public class FileModificationMonitor implements Runnable{

    @Override
    public void run() {
        //调用FileModificationObserver.checkAndNotify
    }
}

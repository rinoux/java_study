package cc.rinoux.concurrent.synchronizemechanism;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by rinoux on 2017/5/31.
 */
public class CustomSynchronizer{

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 1 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }
}

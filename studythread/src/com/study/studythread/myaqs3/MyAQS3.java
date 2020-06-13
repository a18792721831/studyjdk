package com.study.studythread.myaqs3;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class MyAQS3 {

    private final Sync sync = new Sync();

    private class Sync extends AbstractQueuedSynchronizer{

        boolean isSignalled(){
            return getState() != 0;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return isSignalled() ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

    public boolean isSignalled(){
        return sync.isSignalled();
    }

    public void signal(){
        sync.releaseShared(1);
    }

    public void await() throws InterruptedException{
        sync.acquireSharedInterruptibly(1);
    }

}

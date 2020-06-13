package com.study.studythread.myaqs2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class MyAQS1 implements Lock {

    private volatile Sync sync = new Sync();

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            int state = getState();
            if ((Thread.currentThread() == getExclusiveOwnerThread() || getExclusiveOwnerThread() == null)
                    && compareAndSetState(state, state + 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            int state = getState();
            if (Thread.currentThread() == getExclusiveOwnerThread()
                    && compareAndSetState(state, state - 1)) {
                setExclusiveOwnerThread(getState() == 0 ? null : getExclusiveOwnerThread());
                return true;
            }
            return false;
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

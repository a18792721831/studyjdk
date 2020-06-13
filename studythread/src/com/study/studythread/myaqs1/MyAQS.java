package com.study.studythread.myaqs1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class MyAQS implements Lock {

    private volatile Sync sync = new Sync();

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            // 独占模式获取锁
            assert arg == 1; // arg 必须等于 1
            if (compareAndSetState(0, 1)) { // 修改锁占用状态成功
                setExclusiveOwnerThread(Thread.currentThread()); // 设置锁占用线程
                return true; // 锁获取成功
            }
            return false; // 锁获取失败
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 独占模式释放锁
            assert arg == 1; // arg 必须等于 1
            if (Thread.currentThread() == getExclusiveOwnerThread()) {
                setExclusiveOwnerThread(null); // 清空占用锁线程
                setState(0); // 设置锁空闲
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

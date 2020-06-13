package com.study.studythread.LockStudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class MyLock implements Lock {

    private volatile int value;

    @Override
    public void lock() {
        synchronized (this) {
            while (value != 0){
                try {
                    this.wait(); // 重量级锁  CAS自旋
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            value = 1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return value == 1;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            value = 0;
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

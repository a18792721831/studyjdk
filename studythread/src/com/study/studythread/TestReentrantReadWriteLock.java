package com.study.studythread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiayq
 * @Date 2020/6/30
 */
public class TestReentrantReadWriteLock {

    private static volatile int sum = 0;

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
        Lock readLock = lock.readLock();
        Runnable runnable = () -> {
            readLock.tryLock();
            try{
                readLock.tryLock();
                readLock.tryLock();
                readLock.tryLock();
                System.out.println(sum);
            }finally {
                readLock.unlock();
                readLock.unlock();
                readLock.unlock();
            }
        };
        new Thread(runnable,"第一个").start();
        new Thread(runnable,"第二个").start();
    }

}

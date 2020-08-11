package com.study.studythread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author jiayq
 * @Date 2020/7/8
 */
public class MyStampedLock {

    private static volatile int sum = 0;

    public static void main(String[] args) throws InterruptedException {

        StampedLock stampedLock = new StampedLock();

        Runnable reader = () -> {
            String name = Thread.currentThread().getName();
            // 定义凭证
            long state = 0;
            // 获取读锁
            state = stampedLock.readLock();
            // 线程睡眠100ms
            try {
                System.out.println(name + " readLock , state = \t" + Long.toBinaryString(state) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(name + "ie");
            } finally {
                // 释放锁
                stampedLock.unlockRead(state);
            }
        };
        Runnable writer = () -> {
            String name = Thread.currentThread().getName();
            // 定义凭证
            long state = 0;
            // 获取写锁
            state = stampedLock.writeLock();
            sum++;
            // 线程睡眠100ms
            try {
                System.out.println(name + " writeLock , state = \t" + Long.toBinaryString(state) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(name + "ie");
            } finally {
                // 释放写锁
                stampedLock.unlockWrite(state);
            }
        };

        Runnable writer2Reader = () -> {
            String name = Thread.currentThread().getName();
            // 定义凭证
            long state = 0;
            // 获取写锁
            state = stampedLock.writeLock();
            sum++;
            // 转换为读锁
            // 锁降级
            state = stampedLock.tryConvertToReadLock(state);
            // 线程睡眠200ms
            try {
                System.out.println(name + " , writer2Reader , state = \t" + Long.toBinaryString(state) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                System.out.println(name + "ie");
            } finally {
                // 释放锁
                stampedLock.unlock(state);
            }

        };

        Runnable reader2Writer = () -> {
            String name = Thread.currentThread().getName();
            // 定义凭证
            long state = 0;
            // 获取读锁
            state = stampedLock.readLock();
            System.out.println(name + " , reader2Writer , state = \t" + Long.toBinaryString(state) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            // 锁升级
            try {
                Thread.sleep(150);
                if (stampedLock.validate(state)) {
                    state = stampedLock.tryConvertToWriteLock(state);
                } else {
                    state = stampedLock.writeLock();
                }
                sum++;
                System.out.println(name + " , reader2Writer , state = \t" + Long.toBinaryString(state) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            } catch (InterruptedException ie) {
                System.out.println(name + "id");
            } finally {
                stampedLock.tryUnlockWrite();
            }
        };

        Runnable lockerReader = () -> {
            String name = Thread.currentThread().getName();
            Lock read = stampedLock.asReadLock();
            read.lock();
            try {
                System.out.println(name + " , locker , state = \t" + Long.toBinaryString(0) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            } finally {
                read.unlock();
            }
        };

        Runnable lockerWriter = () -> {
            String name = Thread.currentThread().getName();
            Lock write = stampedLock.asWriteLock();
            write.lock();
            try {
                sum++;
                System.out.println(name + " , locker , state = \t" + Long.toBinaryString(0) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            } finally {
                write.unlock();
            }
        };
        Runnable readWriter = () -> {
            String name = Thread.currentThread().getName();
            ReadWriteLock readWriteLock = stampedLock.asReadWriteLock();
            Lock read = readWriteLock.readLock();
            Lock write = readWriteLock.writeLock();
            write.lock();
            try {
                sum++;
                System.out.println(name + " , locker , state = \t" + Long.toBinaryString(0) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            } finally {
                write.unlock();
            }

            read.lock();
            try {
                System.out.println(name + " , locker , state = \t" + Long.toBinaryString(0) + " , sum = " + sum + " , time = " + System.currentTimeMillis());
            } finally {
                read.unlock();
            }
        };
        System.out.println("start ~!~");
//        new Thread(reader, "reader-1").start();
//        new Thread(reader, "reader-2").start();
//        new Thread(writer, "writer").start();
//        new Thread(reader, "reader-2").start();
//        new Thread(writer2Reader, "writer2Reader-writer").start();
//        new Thread(reader, "writer2Reader-reader").start();
        new Thread(reader, "reader2Writer-reader").start();
        new Thread(reader2Writer, "reader2Writer-writer").start();
        new Thread(lockerReader, "lockerReader").start();
        new Thread(lockerWriter, "lockerWriter").start();
    }

}

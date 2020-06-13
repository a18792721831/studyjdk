package com.study.studythread.myaqs2;

import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class Main {

    public static void main(String[] args) {
        Lock lock = new MyAQS1();
        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            lock.lock();
            try {
                Thread.yield();
                System.out.println(thread.getName() + thread.getId() + " 1 get lock");
                lock.lock();
                try {
                    Thread.yield();
                    System.out.println(thread.getName() + thread.getId() + " 2 get lock");
                } finally {
                    lock.unlock();
                    System.out.println(thread.getName() + thread.getId() + " 2 free lock");
                }
            } finally {
                lock.unlock();
                System.out.println(thread.getName() + thread.getId() + " 1 free lock");
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}

package com.study.studythread.LockStudy;

import java.util.concurrent.TimeUnit;

/**
 * @author jiayq
 * @Date 2020-06-10
 */
public class Student {

    public synchronized static void say() {
        System.out.println("static method");
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + thread.getId());
        while (!thread.isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("static end");
    }

    public synchronized void sing() {
        System.out.println("nomal method");
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + thread.getId());
        while (!thread.isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("nomal method end");
    }
}

package com.study.studythread.LockStudy;

import java.util.concurrent.TimeUnit;

/**
 * @author jiayq
 * @Date 2020-06-10
 */
public class StudentMain {

    public static void main(String[] args) {
        Student student = new Student();
        Thread t1 = new Thread(() -> {
            Student.say();
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            student.sing();
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("main interrupt exception");
        }
        System.out.println("main method , static method and nomal method is BLOCKED");
        new Thread(() -> Student.say()).start();
        new Thread(() -> student.sing()).start();
        new Thread(() -> new Student().sing()).start();
    }

}

package com.study.studythread.myaqs3;

import java.util.concurrent.TimeUnit;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class Main {

    public static void main(String[] args) {
        MyAQS3 myAQS = new MyAQS3();
        Runnable runnable = () -> {
            myAQS.signal();
            System.out.println("signal");
        };
        Runnable runnable1 = () -> {
            Thread thread = Thread.currentThread();
            try {
                System.out.println("before await" + Thread.currentThread().getId());
                myAQS.await();
                System.out.println("await" + Thread.currentThread().getId() + " time = " + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    System.out.println("ie");
                }
                System.out.println("after yield" + Thread.currentThread().getId() + " time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                System.out.println("ie");
            }
        };
        Runnable runnable2 = () -> {
            Thread thread = Thread.currentThread();
            try {
                System.out.println("before await" + Thread.currentThread().getId());
                myAQS.await();
                System.out.println("await" + Thread.currentThread().getId() + " time = " + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ie) {
                    System.out.println("ie");
                }
                System.out.println("after yield" + Thread.currentThread().getId() + " time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                System.out.println("ie");
            }
        };
        System.out.println("await!!!!!");
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            System.out.println("ie");
        }
        System.out.println("signal!!!!!!");
        new Thread(runnable).start();
    }

}

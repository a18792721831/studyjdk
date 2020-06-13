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
            Thread thread = Thread.currentThread();
            myAQS.signal();
            try{
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException ie){
                System.out.println("ie");
            }
            System.out.println(thread.getName() + thread.getId() + " signal ");
        };
        Runnable runnable1 = () -> {
            Thread thread = Thread.currentThread();
            try {
                myAQS.await();

            } catch (InterruptedException e) {
                System.out.println("ie");
            }

        };
    }

}

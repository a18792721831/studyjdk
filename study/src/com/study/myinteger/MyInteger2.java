package com.study.myinteger;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author jiayq
 * @Date 2020-04-18
 */
public class MyInteger2 {


    volatile int sum = 0;
    AtomicIntegerFieldUpdater<MyInteger2> updater = AtomicIntegerFieldUpdater.newUpdater(MyInteger2.class, "sum");
    public static void main(String[] args) throws InterruptedException {

        MyInteger2 myInteger2 = new MyInteger2();
        Thread thread1 = new Thread(myInteger2.new MyRunnable());
        Thread thread2 = new Thread(myInteger2.new MyRunnable());
        Thread thread3 = new Thread(myInteger2.new MyRunnable());
        Thread thread4 = new Thread(myInteger2.new MyRunnable());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        //目标是4W
        System.out.println(myInteger2.sum);

    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i = 0;i < 10000;i++){
                updater.incrementAndGet(MyInteger2.this);
            }
        }
    }

}

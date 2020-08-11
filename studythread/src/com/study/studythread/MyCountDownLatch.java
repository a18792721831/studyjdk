package com.study.studythread;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiayq
 * @Date 2020/7/1
 */
public class MyCountDownLatch {

    public static void main(String[] args) {
        // 创建一个值为count的计数器锁
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            System.out.print(thread.getName() + " start count down : " + countDownLatch.getCount() + " -> ");
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount() + " time is " + System.currentTimeMillis());
        };

        Runnable runnable1 = () -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " await count down latch , time is " + System.currentTimeMillis());
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                System.out.println("ie");
            }
            System.out.println(thread.getName() + " await count down latch end, time is " + System.currentTimeMillis());
        };

        for (int i = 0; i < count; i++) {
            new Thread(runnable1, "awaiter" + i).start();
        }
        for (int i = 0; i < count; i++) {
            new Thread(runnable, "countDown" + i).start();
        }
        System.out.println("main end");
    }

}

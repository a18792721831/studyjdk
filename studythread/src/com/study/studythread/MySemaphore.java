package com.study.studythread;

import java.util.concurrent.Semaphore;

/**
 * @author jiayq
 * @Date 2020/7/4
 */
public class MySemaphore {

    public static void main(String[] args) {
        int count = 100;
        Semaphore semaphore = new Semaphore(count, true);
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            try {
                int need = (int) (Math.random() * 10);
                semaphore.acquire(need);
                System.out.println(name + " get " + need + "\t, now semaphore have " + semaphore.availablePermits());
                Thread.sleep((long) (Math.random() * 10000)); // 睡眠10秒内
                semaphore.release(need);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "村名" + i).start();
        }
    }

}

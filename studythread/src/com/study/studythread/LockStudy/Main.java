package com.study.studythread.LockStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiayq
 * @Date 2020-06-08
 */
public class Main {

    public static void main(String[] args) {
        People people = new People();
        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + thread.getId() + " start ");
            for (int i = 0; i < 10000; i++) {
                people.setSum(people.getSum() + 1);
                people.setAll(people.getAll() + 1);
            }
            System.out.println(thread.getName() + thread.getId() + " end ");
        };
        System.out.println("main thread sum = " + people.getSum() + " , all = " + people.getAll());
        ExecutorService service = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            service.execute(runnable);
        }
        service.shutdown();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            System.out.println("main interrupt exception");
        }
        System.out.println("main end sum = " + people.getSum() + " , all = " + people.getAll());
    }

}
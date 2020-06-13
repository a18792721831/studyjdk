package com.study.studythread.myaqs1;

import com.study.studythread.LockStudy.People;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class NomalMain {

    public static void main(String[] args) {
        Lock lock = new MyAQS();
        People people = new People();
        Runnable runnable = () -> {
            lock.lock();
            try{
                for (int i = 0;i < 1000;i++){
                    people.setSum(people.getSum() + 1);
                }
            } finally {
                lock.unlock();
            }
        };
        ExecutorService service = new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        for(int i = 0;i < 100;i++){
            service.execute(runnable);
        }
        service.shutdown();
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie){
            System.out.println("ie");
        }
        System.out.println("people sum = " + people.getSum());
    }

}

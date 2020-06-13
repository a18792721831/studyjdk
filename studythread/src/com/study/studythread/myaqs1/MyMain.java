package com.study.studythread.myaqs1;

import com.study.studythread.LockStudy.People;

import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class MyMain {

    public static void main(String[] args) {
        Lock lock = new MyAQS();
        Runnable runnable = () -> {
            lock.lock();
            try{
                if(lock.tryLock()){
                    System.out.println("tryLock success");
                    lock.unlock();
                } else{
                    System.out.println("tryLock failed");
                }
            } finally {
                lock.unlock();
            }
        };
        new Thread(runnable).start();
    }

}

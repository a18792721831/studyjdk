package com.study.studythread.myaqs1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author jiayq
 * @Date 2020-06-13
 */
public class Main {

    public static void main(String[] args) {
        Lock lock = new MyAQS();
        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            if(lock.tryLock()){
                System.out.println(thread.getName() + thread.getId() + " tryLock success");
            } else {
                System.out.println(thread.getName() + thread.getId() + " tryLock first failed , unLock now");
                lock.unlock();
                System.out.println(thread.getName() + thread.getId() + " unLock success , and tryLock again");
                if (lock.tryLock()){
                    System.out.println(thread.getName() + thread.getId() + " tryLock success");
                } else {
                    System.out.println(thread.getName() + thread.getId() + " tryLock failed , use lock");
                    lock.lock();
                }
            }
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                System.out.println("ie");
            }finally {
                lock.unlock();
            }
        };
        // 第一个线程加锁，然后在持有锁的状态下，睡眠10秒
        // 在第一个锁睡眠的时候，第二个线程尝试获取锁，如果获取不到锁，尝试释放锁(这里有问题，第二个线程会释放第一个线程的锁)
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            System.out.println("ie");
        }

    }

}

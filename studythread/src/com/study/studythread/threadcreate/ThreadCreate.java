package com.study.studythread.threadcreate;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author jiayq
 * @Date 2020-05-25
 */
public class ThreadCreate {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0;i < 6;i++){
//            service.execute(new LiftOff());
//        }
//        service.shutdown();
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        for (int i = 0;i < 6;i++){
//            service.execute(new LiftOff());
//        }
//        service.shutdown();
//        ExecutorService service = Executors.newScheduledThreadPool(3);
//        for (int i = 0;i < 6;i++){
//            service.execute(new LiftOff());
//        }
//        service.shutdown();
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        for (int i = 0;i < 6;i++){
//            service.execute(new LiftOff());
//        }
//        service.shutdown();
//        ThreadFactory factory = new ThreadFactoryBuilder()
//        ThreadFactory factory = new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return null;
//            }
//        };
//        ExecutorService service = new ThreadPoolExecutor(3, 5,
//                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5));
//        for (int i = 0; i < 6; i++) {
//            service.execute(new LiftOff());
//        }
//        service.shutdown();
//        ExecutorService service = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
//        ArrayList<Future<String>> results = new ArrayList<>();
//        for (int i = 0;i < 10;i++){
//            results.add(service.submit(new RightOff(i)));
//        }
//        for(Future<String> future : results){
//            try {
//                System.out.println(future.isDone());
//                System.out.println(future.get());
//            } catch (ExecutionException e){
//                System.out.println("ExecutionException");
//                return;
//            } catch (Exception e){
//                e.printStackTrace();
//                return;
//            } finally {
//                service.shutdown();
//            }
//        }
//        People people = new People();
//        people.start();
//        System.out.println("people is started!");
//        System.out.println("main thread sleep 5000 !");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            return;
//        }
//        people.interrupt();
//        System.out.println("people interrupt!");
//        System.out.println(Thread.currentThread().getName() + " is start ");
//        Goods goods = new Goods();
//        System.out.println(Thread.currentThread().getName() + " goods is new ");
//        goods.start();
//        System.out.println(Thread.currentThread().getName() + " goods is running");
//        System.out.println(Thread.currentThread().getName() + " sleep 3 ");
//        Thread.sleep(3);
//        goods.interrupt();

//        Runnable daemonDemo = () -> {
//            try{
//                System.out.println("daemon demo is starting run !");
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e){
//                System.out.println("interrupt exception !");
//            } finally {
//                System.out.println("finally daemon demo !");
//            }
//        };
//        System.out.println("c create daemon thread");
//        Thread daemonThread = new Thread(daemonDemo);
//        System.out.println("main thread set daemon is true");
//        daemonThread.setDaemon(true);
//        System.out.println("main thread start");
//        daemonThread.start();
//        System.out.println("main is over");
//        TimeUnit.MILLISECONDS.sleep(300);

//        Runnable daemonDemo = () ->{
//            System.out.println("daemon by main start");
//            Runnable daemon = () -> {
//                System.out.println("daemon by daemon start");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e){
//                    System.out.println("daemon by daemon interrupt exception");
//                } finally {
//                    System.out.println("daemon by daemon finally");
//                }
//            };
//            System.out.println("daemon by main create thread");
//            Thread daemonByDaemon = new Thread(daemon);
//            System.out.println("daemon by daemon get isDaemon : " + daemonByDaemon.isDaemon());
//            daemonByDaemon.start();
//        };
//        Thread daemonDemoThread = new Thread(daemonDemo);
//        daemonDemoThread.setDaemon(true);
//        System.out.println("daemon by main get isDaemon : " + daemonDemoThread.isDaemon());
//        daemonDemoThread.start();
//        TimeUnit.SECONDS.sleep(2);

//        Runnable daemonDemo = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                System.out.println("daemon demo interrupt exception");
//            } finally {
//                System.out.println("deamon demo finally");
//            }
//        };
//        Thread daemon = new Thread(daemonDemo);
//        daemon.setDaemon(true);
//        daemon.setPriority(Thread.MAX_PRIORITY);
//        daemon.start();
//        System.out.println("daemon priority is " + daemon.getPriority());
//        System.out.println("main priority is " + Thread.currentThread().getPriority());

        Child child = new Child();
        child.say();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(child.getThread().isAlive());
        child.getThread().interrupt();
    }

    static class LiftOff implements Runnable {

        protected int countDown = 10;
        private static int taskCount = 0;
        private final int id = taskCount++;

        public LiftOff() {
        }

        public LiftOff(int countDown) {
            this.countDown = countDown;
        }

        public String status() {
            return "#" + id + "(" +
                    (countDown > 0 ? countDown : "LiftOff!") + ").";
        }

        @Override
        public void run() {
            while (countDown-- >= 0) {
                System.out.println(status());
                Thread.yield();
            }
        }
    }

    static class RightOff implements Callable<String> {

        private int id;

        public RightOff(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            return "result of " + Thread.currentThread().getId() + ":" + id;
        }
    }

    static class Study implements Runnable {

        private volatile boolean exit = false;

        @Override
        public void run() {
            while (!exit) {
                // TODO: doSomething
            }
        }
    }

    static class People extends Thread {
        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep 1000 !");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptException");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "is down!");

        }
    }

    static class Goods extends Thread {
        @Override
        public void run() {
            int x = 0;
            System.out.println(getName() + " is in run method!");
            while (!isInterrupted()) {
                System.out.println(getName() + " input while " + x);
                x++;
            }
            System.out.println(getName() + " is out run method!");
        }
    }

    static class Father {
        public void say() {
            System.out.println("father say!");
        }
    }

    static class Child extends Father implements Runnable {

        private Thread thread = new Thread(this);

        {
            thread.start();
        }

        public Thread getThread(){
            return thread;
        }

        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("child run!");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("child interrupt exception!");
            } finally {
                System.out.println("child finally!");
            }
        }
    }

}

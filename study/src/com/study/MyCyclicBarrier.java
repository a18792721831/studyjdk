package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jiayq
 * @Date 2020-07-02W
 */
public class MyCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        Runnable barrierAction = () -> {
            System.out.println("裁判:开始比赛--------");
        };
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, barrierAction);
        Runnable runner = () -> {
            String name;
            System.out.println("运动员" + (name = Thread.currentThread().getName()) + ":准备完成");
            try {
                Thread.sleep(300);//运动员需要300毫秒准备比赛
                cyclicBarrier.await();
                System.out.println("远动员" + name + "开跑");
            } catch (InterruptedException e) {
                System.out.println("ie");
            } catch (BrokenBarrierException e) {
                System.out.println("比赛取消！！！！");
            }
        };
        for (int i = 0; i < 5; i++) {
            List<Thread> threads = new ArrayList<>(count);
            for (int j = 0; j < count; j++) {
                threads.add(new Thread(runner,j+""));
            }
            for (Thread thread: threads){
                thread.start(); // 运动员就位
            }
            for (Thread thread: threads){
                thread.join(); // 等待运动员开跑
            }
            cyclicBarrier.reset(); // 重置
            System.out.println(); // 分割
        }
    }

}

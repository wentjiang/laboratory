package com.wentjiang.laboratory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangwentao on 1/24/2017 10:37 AM.
 */
public class TestHashSet implements Runnable{
    // 实现Runnable 让该集合能被多个线程访问
    Set<Integer> set = new HashSet<Integer>();
    // 线程的执行就是插入5000个整数
    @Override
    public void run() {
        for (int i = 0;i < 50;i ++) {
            set.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestHashSet run2 = new TestHashSet();
        // 实例化两个线程
        Thread t6 = new Thread(run2);
        Thread t7 = new Thread(run2);
        Thread t8 = new Thread(run2);
        // 启动两个线程
        t6.start();
//        t7.start();
//        t8.start();

        // 当前线程等待加入到调用线程后
        t6.join();
//        t7.join();
//        t8.join();

        Thread.sleep(1000);
        // 打印出集合的size
        System.out.println(run2.set.size());
        for (Integer num : run2.set){
            System.out.println(num);
        }
    }
}

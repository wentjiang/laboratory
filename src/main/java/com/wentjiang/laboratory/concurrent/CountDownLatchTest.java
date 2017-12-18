package com.wentjiang.laboratory.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiangwentao
 * @create 2017-11-17 15:59
 * @desc
 **/
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int threadNum = 5;
        CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println("start :" + temp);
                try {
                    latch.countDown();
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println(latch.getCount());
        }
//        synchronized (CountDownLatchTest.class) {
//            CountDownLatchTest.class.wait();
//        }
    }
}

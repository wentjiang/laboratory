package com.wentjiang.laboratory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiangwentao on 2017/6/19 15:13.
 */
public class VolatileTest {

    private static Integer count = 0;

    private static volatile Integer countWithVolatile = 0;

    public static void main(String[] args) {
        System.out.println("total count : 10000");
        addVolatileTest();
        notVolatileTest();
    }

    public static void addVolatileTest() {
        Integer loop = 10;

        ExecutorService pool = Executors.newFixedThreadPool(loop);
        CountDownLatch latch = new CountDownLatch(loop);

        final Object object = new Object();

        for (int j = 0; j < loop; j++) {
            pool.execute(() -> {
                synchronized (object) {
                    for (int i = 0; i < 1000; i++) {
                        countWithVolatile++;
                    }
                    latch.countDown();
                }
            });
        }


        try {
            pool.shutdown();
            pool.awaitTermination(30, TimeUnit.SECONDS);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("countWithVolatile:" + countWithVolatile);
    }

    public static void notVolatileTest() {
        Integer loop = 10;

        ExecutorService pool = Executors.newFixedThreadPool(loop);
        CountDownLatch latch = new CountDownLatch(loop);
        for (int j = 0; j < loop; j++) {
            pool.execute(() -> {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
                latch.countDown();
            });
        }

        pool.shutdown();
        try

        {
            pool.awaitTermination(30, TimeUnit.SECONDS);
            latch.await();
        } catch (
                InterruptedException e)

        {
            e.printStackTrace();
        }
        System.out.println("count:" + count);
    }

}

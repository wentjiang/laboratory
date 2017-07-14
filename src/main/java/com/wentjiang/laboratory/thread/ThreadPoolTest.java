package com.wentjiang.laboratory.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiangwentao on 2017/6/21 16:22.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        testCachedThreadPool();
//        testFixedThreadPool();
//        testScheduledThreadPool();
        testNewSingleThreadExecutor();
    }

    private static void testCachedThreadPool() {
        System.out.println("start test cachedthreadpool");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    private static void testFixedThreadPool() {
        System.out.println("test FixedThreadPool");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void testScheduledThreadPool() {
        System.out.println("start test sheduledthreadpool");
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds, and excute every 1 seconds");
            }
        }, 3, 1, TimeUnit.SECONDS);
    }

    private static void testNewSingleThreadExecutor() {
        System.out.println("start test NewSingleThreadExecutor");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}

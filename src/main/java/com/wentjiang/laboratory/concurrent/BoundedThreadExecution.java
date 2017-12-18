package com.wentjiang.laboratory.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author jiangwentao
 * @create 2017-11-16 10:23
 * @desc
 **/
public class BoundedThreadExecution {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(50);
        final CountDownLatch gate = new CountDownLatch(1);
        int maxThreads = 5;
        for (int i = 0; i < maxThreads; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    gate.await();
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "-->" + index + "--available permits=" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                finally {
                    // 不管当前线程是否正常结束，都释放许可
                    semaphore.release();
                }
            }).start();

        }
        // 使用闭锁来实现所有线程同时开始执行
        gate.countDown();
    }
}

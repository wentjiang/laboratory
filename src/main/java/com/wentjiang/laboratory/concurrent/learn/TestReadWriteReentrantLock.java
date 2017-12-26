package com.wentjiang.laboratory.concurrent.learn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiangwentao
 * @create 2017-12-26 9:40
 * @desc
 **/
@Slf4j
public class TestReadWriteReentrantLock {
    public static void main(String[] args) throws RuntimeException {
        new TestReadWriteReentrantLock().test();
    }

    public void test() {
        final ReentrantReadWriteLock objectLock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                ReentrantReadWriteLock.WriteLock writeLock = objectLock.writeLock();
                writeLock.lock();
                log.info("做了一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                ReentrantReadWriteLock.WriteLock writeLock = objectLock.writeLock();
                writeLock.lock();
                log.info("做了另一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                ReentrantReadWriteLock.ReadLock readLock = objectLock.readLock();
                readLock.lock();
                log.info("做了一些读操作的事情。。。。");
                readLock.unlock();
            }
        };

        //thread1、thread2、thread3在运行过程中，将按照我们之前描述的规律，相互作用
        thread1.start();
        thread2.start();
        // 您可以使用thread1.interrupt()指令对ReentrantLock的影像。
        // 您可以发现，thread1在加锁后并不会抛出interruptException异常
        // 至少在我们这种使用方式下，不会抛出异常
        // thread1.interrupt();
        thread3.start();
    }
}

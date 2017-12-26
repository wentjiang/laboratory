package com.wentjiang.laboratory.concurrent.learn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangwentao
 * @create 2017-12-25 19:38
 * @desc
 **/
public class Test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("in lock!");
        lock.unlock();
    }
}

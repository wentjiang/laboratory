package com.wentjiang.laboratory.concurrent;

/**
 * @author jiangwentao
 * @create 2017-11-16 10:53
 * @desc
 **/
public class CountingSemaphore {

    private final int bound;
    private int permits = 0;

    public CountingSemaphore(int permits){
        if (permits <= 0){
            throw new IllegalArgumentException();
        }
        this.bound = permits;
    }

    public synchronized void acquired() throws InterruptedException{
        while (permits == bound){
            wait();
        }
        permits++;
    }

    public synchronized void release(){
        permits--;
        notifyAll();
    }

}

package com.wentjiang.laboratory.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author jiangwentao
 * @create 2017-11-16 9:51
 * @desc
 **/
public class SemaphoreTest {

    private Semaphore semaphore;

    public SemaphoreTest(int permits){
        if (permits <= 0){
            throw new IllegalArgumentException("permits must be greater than 0");
        }
        semaphore = new Semaphore(permits);
    }

    public void operation() throws InterruptedException{
        semaphore.acquire();
        try {
            //do something
        }
        finally{
            semaphore.release();
        }
    }

}

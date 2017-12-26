package com.wentjiang.laboratory.concurrent.learn;

import lombok.extern.log4j.Log4j;

/**
 * @author jiangwentao
 * @create 2017-12-25 14:27
 * @desc
 **/
@Log4j
public class ChildNotifyThread implements Runnable{

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        log.info("线程 id :" + id + "启动成功,进入准备状态!" );
        synchronized (ParentNotifyThread.CHILD_WAIT_OBJECT){
            try {
                ParentNotifyThread.CHILD_WAIT_OBJECT.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("线程 id :" + id + "被唤醒");
    }
}

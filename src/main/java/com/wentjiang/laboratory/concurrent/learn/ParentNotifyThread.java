package com.wentjiang.laboratory.concurrent.learn;

/**
 * @author jiangwentao
 * @create 2017-12-25 14:18
 * @desc
 **/
public class ParentNotifyThread implements Runnable {

    public static final Object CHILD_WAIT_OBJECT = new Object();

    public static void main(String[] args) {
        new Thread(new ParentNotifyThread()).start();
    }

    @Override
    public void run() {

        int indexMax = 3;
        for (int i = 0 ; i< indexMax ; i++){
            ChildNotifyThread childNotify = new ChildNotifyThread();
            Thread childNotifyThread = new Thread(childNotify);
            childNotifyThread.start();
        }

        synchronized (ParentNotifyThread.CHILD_WAIT_OBJECT){
            ParentNotifyThread.CHILD_WAIT_OBJECT.notify();
        }

        synchronized (ParentNotifyThread.class){
            try {
                ParentNotifyThread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

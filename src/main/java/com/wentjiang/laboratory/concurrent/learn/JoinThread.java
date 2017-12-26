package com.wentjiang.laboratory.concurrent.learn;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangwentao
 * @create 2017-12-25 15:31
 * @desc
 **/
@Slf4j
public class JoinThread implements  Runnable{

    public static void main(String[] args) throws Exception {
        /*
         * 启动一个子线程joinThread，然后等待子线程joinThread运行完成后
         * 这个线程再继续运行
         * */
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        Thread joinThread = new Thread(new JoinThread());
        joinThread.start();

        try {
            // 等待，知道joinThread执行完成后，main线程才继续执行
            joinThread.join();
            log.info("线程" + id + "继续执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        log.info("线程" + id + "启动成功，准备进入等待状态（5秒）");

        // 使用sleep方法，模型这个线程执行业务代码的过程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

        //执行到这里，说明线程被唤醒了
        log.info("线程" + id + "执行完成！");
    }
}

package com.wentjiang.laboratory.concurrent.learn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangwentao
 * @create 2017-12-25 16:03
 * @desc
 **/
public class PoolThreadSimple {
    public static void main(String[] args) throws Throwable {

        /*
         * corePoolSize：核心大小，线程池初始化的时候，就会有这么大
         * maximumPoolSize：线程池最大线程数
         * keepAliveTime：如果当前线程池中线程数大于corePoolSize。
         * 多余的线程，在等待keepAliveTime时间后如果还没有新的线程任务指派给它，它就会被回收
         *
         * unit：等待时间keepAliveTime的单位
         *
         * workQueue：等待队列。这个对象的设置是本文将重点介绍的内容
         * */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 1,
                TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
        for(int index = 0 ; index < 10 ; index ++) {
            poolExecutor.submit(new PoolThreadSimple.TestRunnable(index));
        }

        // 没有特殊含义，只是为了保证main线程不会退出
        synchronized (poolExecutor) {
            poolExecutor.wait();
        }
    }

    /**
     * 这个就是测试用的线程
     * @author yinwenjie
     */
    @Slf4j
    private static class TestRunnable implements Runnable {

        /**
         * 记录任务的唯一编号，这样在日志中好做识别
         */
        private Integer index;

        public TestRunnable(int index) {
            this.index = index;
        }

        /**
         * @return the index
         */
        public Integer getIndex() {
            return index;
        }

        @Override
        public void run() {
            /*
             * 线程中，就只做一件事情：
             * 等待60秒钟的事件，以便模拟业务操作过程
             * */
            Thread currentThread  = Thread.currentThread();
            log.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）开始执行===");
            synchronized (currentThread) {
                try {
                    currentThread.wait(60000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            }

            log.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）执行完成");
        }

    }
}

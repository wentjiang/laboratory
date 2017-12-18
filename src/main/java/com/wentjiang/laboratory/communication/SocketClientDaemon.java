package com.wentjiang.laboratory.communication;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * @author jiangwentao
 * @create 2017-11-17 12:27
 * @desc
 **/
public class SocketClientDaemon {

    public static void main(String[] args) throws InterruptedException {

        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(threadNum);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, threadNum, 20, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new NamedThreadFactory("clientDaemon"));
        for (int i = 0; i < threadNum; i++) {
            SocketClientRequestThread client = new SocketClientRequestThread(latch, i);
            executor.execute(client);
            latch.countDown();
            System.out.println("latch count : " + latch.getCount());
        }

        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDaemon.class) {
            SocketClientDaemon.class.wait();
        }

    }

}

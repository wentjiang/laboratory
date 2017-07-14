package com.wentjiang.laboratory;

/**
 * Created by jiangwentao on 2017/6/20 17:19.
 */
public class ThreadTest {
    public static void main(String[] args) {
//        a）给线程命名，这样可以帮助调试。
//        b）最小化同步的范围，而不是将整个方法同步，只对关键部分做同步。
//        c）如果可以，更偏向于使用 volatile 而不是 synchronized。
//        d）使用更高层次的并发工具，而不是使用 wait() 和 notify() 来实现线程间通信，如 BlockingQueue，CountDownLatch 及 Semeaphore。
//        e）优先使用并发集合，而不是对集合进行同步。并发集合提供更好的可扩展性。
        Thread thread = new Thread(()->{
            System.out.println("hello world");
            throw new RuntimeException();
        });
        thread.setName("wentjiang's thread");
        thread.start();
    }
}

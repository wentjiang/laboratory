package com.wentjiang.laboratory.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiangwentao on 2017/10/16 18:02.
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicTest test = new AtomicTest();
        test.test();
    }

    public void test(){
//        Class var0 = Reflection.getCallerClass();
//        System.out.println(var0.getSimpleName());
        AtomicInteger num = new AtomicInteger();
        int count = num.addAndGet(1);

        System.out.println(count);
    }

}

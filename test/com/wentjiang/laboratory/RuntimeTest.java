package com.wentjiang.laboratory;

/**
 * Created by jiangwentao on 2017/6/20 14:58.
 */
public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("availableProcessors : " + runtime.availableProcessors());
        System.out.println("freeMemory : " + runtime.freeMemory());
        System.out.println("maxMemory : " + runtime.maxMemory());
        System.out.println("totalMemory : "+runtime.totalMemory());
    }
}

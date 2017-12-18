package com.wentjiang.laboratory.designMode.proxy2;

import java.lang.reflect.Proxy;

/**
 * @author jiangwentao
 * @create 2017-12-18 16:09
 * @desc
 **/
public class Test {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        TargetOneInterface target = new ClassOne();
        ProxyClass handler = new ProxyClass(target);
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{TargetOneInterface.class}, handler);

        TargetOneInterface targetOneInterface = (TargetOneInterface) proxy;
        String result = targetOneInterface.method0("wentjiang");
        System.out.println(result);
    }
}

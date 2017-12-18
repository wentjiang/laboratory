package com.wentjiang.laboratory.designMode.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author jiangwentao
 * @create 2017-12-18 16:08
 * @desc
 **/
public class ProxyClass implements InvocationHandler{

    private Object target;

    public ProxyClass(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==============================");
        System.out.println("代理者的对象:" + proxy.getClass().getName());
        Class<?> targetClass = method.getDeclaringClass();
        System.out.println("被代理的接口类:" + targetClass.getName());
        System.out.println("被代理的方法:" + method.getName());
        if (args == null){
            return null;
        }

        System.out.println("被代理的调用过程参数类型:");
        Arrays.stream(args).forEach((item)->{
            System.out.println("方法类型:" + item.getClass().getName());
        });

        Object result  = method.invoke(target,args);

        return result;
    }
}

package com.wentjiang.laboratory.designMode.proxy.example2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jiangwentao on 2017/8/14 15:08.
 */
public class DirverInvocationHandler implements InvocationHandler {

    private Object target;

    public DirverInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy.toString());
        System.out.println(args.toString());
        System.out.println("before invoke");
        Object result = method.invoke(target, args);
        System.out.println("after incoke");
        return result;
    }
}

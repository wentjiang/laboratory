package com.wentjiang.laboratory.designMode.proxy.example1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jiangwentao on 2/21/2017 6:08 PM.
 */
public class PeopleInvocationHandler implements InvocationHandler {
    private Object target;

    public PeopleInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before say");
        Object result = method.invoke(target,args);
        System.out.println("after say");
        return result;
    }
}

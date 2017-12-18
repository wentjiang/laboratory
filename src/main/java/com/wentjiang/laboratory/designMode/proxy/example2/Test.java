package com.wentjiang.laboratory.designMode.proxy.example2;

import java.lang.reflect.Proxy;

/**
 * Created by jiangwentao on 2017/8/14 15:13.
 */
public class Test {
    public static void main(String[] args) {
        Drive boss = new Boss();
        Car car = new Car("BMW");
        Drive proxy = (Drive) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{Drive.class},
                new DirverInvocationHandler(boss));
        proxy.driverCar(car);
    }
}

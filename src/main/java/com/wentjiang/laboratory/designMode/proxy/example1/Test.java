package com.wentjiang.laboratory.designMode.proxy.example1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;

/**
 * Created by jiangwentao on 2/21/2017 6:16 PM.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Say people = new People();
        Say proxy = (Say) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{Say.class,Run.class},
                new PeopleInvocationHandler(people));
        Run proxy2 = (Run) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{Say.class,Run.class},
                new PeopleInvocationHandler(people));

        proxy.say("hahaha");
        proxy2.run();

        System.out.println(proxy.getClass().getName());
        System.out.println(proxy.getClass().getSimpleName());
        System.out.println(proxy.getClass().getCanonicalName());
        Class<? extends Say> aClass = proxy.getClass();
        FileOutputStream fs = new FileOutputStream("d:/tmp.class");
        ObjectOutputStream os =  new ObjectOutputStream(fs);
        os.writeObject(aClass);
        os.close();
        System.out.println(new File(Test.class.getResource("/").getFile()).getAbsolutePath());
    }
}

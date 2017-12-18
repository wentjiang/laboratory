package com.wentjiang.laboratory.designMode.proxy.example1;

/**
 * Created by jiangwentao on 2/21/2017 6:06 PM.
 */
public class People implements Say,Run {
    private int age;

    @Override
    public void say(String word) {
        System.out.println("people say :" + word);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void run() {
        System.out.println("people run fast");
    }
}

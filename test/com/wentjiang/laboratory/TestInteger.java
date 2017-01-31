package com.wentjiang.laboratory;

/**
 * Created by wentj on 2017-1-24.
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer num1 = 111;
        Integer num2 = 111;
        Integer num3 = 130;
        Integer num4 = 130;
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));
        System.out.println(num3 == num4);
        System.out.println(num3.equals(num4));
    }
}

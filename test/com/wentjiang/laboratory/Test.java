package com.wentjiang.laboratory;

/**
 * Created by jiangwentao on 10/13/2016.
 */
public class Test {
    public static void main(String[] args) {
        Integer num = 129;
        System.out.println(Integer.toBinaryString(num));
        Byte num2 = num.byteValue();
        Integer num3 = new Integer(num2);

        System.out.println(num.byteValue());;
        System.out.println(Integer.toBinaryString(num3));
    }
}

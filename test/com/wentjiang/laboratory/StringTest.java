package com.wentjiang.laboratory;

import org.apache.commons.lang.StringUtils;

/**
 * Created by jiangwentao on 2017/6/20 17:41.
 */
public class StringTest {
    public static void main(String[] args) {

        System.out.println(inversionStr("hello world"));
        System.out.println(inversionStr("jiangwentao1"));
        System.out.println(inversionStr(""));
    }

    //反转字符串
    public static String inversionStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        char[] chars = str.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size / 2; i++) {
            char temp = chars[size - 1 - i];
            chars[size - 1 - i] = chars[i];
            chars[i] = temp;
        }
        String newStr = new String(chars);

        return newStr;
    }
}

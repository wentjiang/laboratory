package com.wentjiang.laboratory.util;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by jiangwentao on 2017/6/13 16:23.
 */
public class Base64Util {

    /**
     * 获取base64加密串
     */
    public static String getBase64(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        byte[] bytes = null;
        String result = null;

        bytes = str.getBytes(StandardCharsets.UTF_8);

        result = new BASE64Encoder().encode(bytes);
        return result;
    }

    /**
     * 获取base64解密串
     */
    public static String deBase64(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        byte[] bytes = null;
        String result = null;

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            bytes = decoder.decodeBuffer(str);
            result = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String name = "江文韬";
        System.out.println(name);

        String base64Name = getBase64(name);

        System.out.println(base64Name);

        String deName = deBase64(base64Name);

        System.out.println(deName);
    }
}

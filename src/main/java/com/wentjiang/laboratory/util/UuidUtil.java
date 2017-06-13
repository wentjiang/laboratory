package com.wentjiang.laboratory.util;

import java.util.UUID;

/**
 * Created by jiangwentao on 2017/6/13 14:24.
 */
public class UuidUtil {

    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", "");
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getUuid());
    }
}

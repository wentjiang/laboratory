package com.wentjiang.laboratory;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jiangwentao on 2017/6/20 15:27.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        Map<String ,String> map = new TreeMap<>();
        map.put("11","11");
        map.put("88","88");
        map.put("66","66");
        map.put("cc","cc");
        map.put("aa","aa");
        map.put("bb","bb");
        map.put("zz","zz");
        System.out.println(map.toString());

    }
}

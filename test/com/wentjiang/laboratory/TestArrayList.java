package com.wentjiang.laboratory;

import java.util.*;

/**
 * Created by wentj on 2017-1-24.
 */
public class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list.toString());
        //反例
//        for (String s : list){
//            if ("2".equals(s)){
//
//                list.remove(s);
//            }
//        }
//
        //正确方法
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){

            if ("2".equals(iterator.next())){
                iterator.remove();
            }
        }
        System.out.println(list.toString());
        Set<String> set = new HashSet<>();
    }
}

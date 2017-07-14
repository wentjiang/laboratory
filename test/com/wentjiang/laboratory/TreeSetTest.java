package com.wentjiang.laboratory;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jiangwentao on 2017/6/20 15:25.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(88);
        set.add(77);
        set.add(55);
        set.add(66);
        set.add(99);
        set.add(1);
        System.out.println(set.toString());
    }
}

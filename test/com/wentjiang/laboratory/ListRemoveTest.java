package com.wentjiang.laboratory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jiangwentao on 2017/6/20 16:02.
 */
public class ListRemoveTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.toString());

        //error remove method
//        for (Integer num : list) {
//            if (num == 3) {
//                list.remove(num);
//            }
//        }

        //right remove method
        Iterator<Integer> iterable = list.iterator();

        while (iterable.hasNext()) {
            int num;
            if ((num = iterable.next()) == 3) {
                iterable.remove();
            }
            System.out.println(num);
        }

        System.out.println(list.toString());
    }
}

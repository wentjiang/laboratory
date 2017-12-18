package com.wentjiang.laboratory.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * Created by jiangwentao on 2017/10/16 15:42.
 */
public class ReferenceTest {
    public static void main(String[] args) {
        //强引用
        Date date = new Date();
        //软引用
        SoftReference<Date> softReference = new SoftReference<>(date);
        //弱引用
        WeakReference<Date> weakReference = new WeakReference<>(date);
        //虚引用
//        PhantomReference<Date> phantomReference = new PhantomReference<>(date);

    }
}

package com.wentjiang.laboratory.util;

import java.util.Iterator;

/**
 * Created by jiangwentao on 2017/6/20 16:45.
 */
public class JwtList<T> implements Iterator<T> {

    private int size;
    private Object[] objects;

    public JwtList() {
        size = 12;
        objects = new Object[12];
    }


    public void add(T object) {
        if (objects.length == size) {
            Object[] temp = new Object[size * 2];
            System.arraycopy(objects, 0, temp, 0, objects.length);
            objects = temp;
        }
        size++;
        objects[size] = object;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}

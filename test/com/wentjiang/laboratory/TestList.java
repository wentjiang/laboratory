package com.wentjiang.laboratory;

import com.wentjiang.laboratory.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangwentao on 2017/9/19 14:49.
 */
public class TestList {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student0 = Student.builder().id(1).name("wentjiang").age(23).build();
        Student student1 = Student.builder().id(2).name("wentjiang2").age(232).build();

        Map<Integer,Student> map = new HashMap<>();
        map.put(student0.getId(),student0);
        map.put(student1.getId(),student1);
        students.add(student0);
        students.add(student1);
        Integer findId = 2;
        Student student = map.get(findId);
        int index = students.indexOf(student);
        System.out.println(index);


    }
}

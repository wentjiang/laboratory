package com.wentjiang.laboratory.controller;

import com.wentjiang.laboratory.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangwentao on 2017/9/19 12:27.
 */
@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("getStudent")
    public @ResponseBody Student getStudent(){
        Student student = new Student();
        student.setId(1);
        student.setAge(23);
        student.setName("wentjiang");
        return student;
    }
}

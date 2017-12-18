package com.wentjiang.laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jiangwentao on 2017/9/19 12:27.
 */
@Data
@Builder
@AllArgsConstructor
@XmlRootElement(name = "student")
public class Student {
    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "age")
    private Integer age;
    @XmlElement(name = "name")
    private String name;

    public Student(){

    }

}

package com.wentjiang.laboratory.jdbcTemplate;

import java.io.Serializable;

/**
 * Created by jiangwentao on 11/23/2016 10:41 AM.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private int age;
    private String username;

    public User() {
    }

    public User(String name, int age, String username) {
        this.name = name;
        this.age = age;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

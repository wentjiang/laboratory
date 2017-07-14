package com.wentjiang.laboratory;

/**
 * Created by jiangwentao on 2017/6/21 14:36.
 */
public class UserTest {

    public static void main(String[] args) {
        User user = new User("jwt",23);
        User.builder().name("jiangwentao").age(23).build();
    }
}

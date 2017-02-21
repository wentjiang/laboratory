package com.wentjiang.laboratory;

import com.wentjiang.BaseTest;
import com.wentjiang.laboratory.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by jiangwentao on 11/23/2016 10:33 AM.
 */
public class JdbcTemplateTest extends BaseTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String USER_INSERT_SQL =
            "insert into user (name , age , username) " +
                    "values (?,?,?)";

    @org.junit.Test
    public void queryUser() {
//        jdbcTemplate.update("insert into user (name , age , username) " +
//                "values (:name,:age,:username)", user.getName(), user.getAge(), user.getUsername());
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from user");
        for (Map<String,Object> map :list){
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
        System.out.println("success");
    }
    @org.junit.Test
    public void addUser(){
        User user = new User("jiangwentao1", 24, "wentjiang1");
        jdbcTemplate.update(USER_INSERT_SQL,user.getName(),user.getAge(),user.getUsername());
        System.out.println("success");
    }

    @org.junit.Test
    public void deleteUser(){
        String DELETE_SQL = "delete from user where id = ?";
        jdbcTemplate.update(DELETE_SQL,2);
        System.out.println("success");
    }

}

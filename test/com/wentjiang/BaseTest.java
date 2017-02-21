package com.wentjiang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiangwentao on 11/23/2016 10:32 AM.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations="classpath:conf/applicationContext*.xml") // 加载配置
public class BaseTest {

    @Test
    public void baseTest(){
        System.out.println("success");
    }
}

package com.wentjiang.laboratory;

import com.wentjiang.BaseTest;
import com.wentjiang.laboratory.activeMQ.ProducerService;
import com.wentjiang.laboratory.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.jms.Destination;

/**
 * Created by jiangwentao on 11/23/2016 3:01 PM.
 */
public class ProducerConsumerTest extends BaseTest{
    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @org.junit.Test
    public void testSend() {
        for (int i=0; i<20; i++) {
//            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
            producerService.sendObjectMessage(destination,new User(12, "jiang"+i,23,"wentjiang"));
        }
    }
}

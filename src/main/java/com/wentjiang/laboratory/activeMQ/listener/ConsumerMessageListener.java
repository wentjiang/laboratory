package com.wentjiang.laboratory.activeMQ.listener;

import com.wentjiang.laboratory.jdbcTemplate.User;

import javax.jms.*;

/**
 * Created by jiangwentao on 11/23/2016 2:54 PM.
 */
public class ConsumerMessageListener implements MessageListener {
    public void onMessage(Message message) {
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
//        TextMessage textMsg = (TextMessage) message;
        ObjectMessage objectMessage = (ObjectMessage) message;
//        System.out.println("接收到一个纯文本消息。");
        User user = null;
        try {
            user = (User) objectMessage.getObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println("消息内容是：" + user.getName() + user.getUsername() + user.getAge());
    }
}

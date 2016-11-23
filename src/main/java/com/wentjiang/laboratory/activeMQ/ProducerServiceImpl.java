package com.wentjiang.laboratory.activeMQ;

import com.wentjiang.laboratory.jdbcTemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by jiangwentao on 11/23/2016 3:04 PM.
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
        System.out.println("------------生产者发送消息-------------");
        System.out.println("------------发送消息内容: " + message + "--------------------------");
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendObjectMessage(Destination destination, final User user) {
        System.out.println("-------------发送对象消息---------------");
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}

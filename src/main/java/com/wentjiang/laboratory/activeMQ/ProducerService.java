package com.wentjiang.laboratory.activeMQ;

import com.wentjiang.laboratory.jdbcTemplate.User;

import javax.jms.Destination;

/**
 * Created by jiangwentao on 11/23/2016 3:03 PM.
 */
public interface ProducerService {
    void sendMessage(Destination destination, final String message);
    void sendObjectMessage(Destination destination,User user);
}

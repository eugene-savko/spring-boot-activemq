package com.solution.activemq.services;

import com.solution.activemq.config.ActiveMQConfig;
import com.solution.activemq.model.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Consumer {

    public static final String GUID = UUID.randomUUID().toString();

    @JmsListener(destination = "simple.queue")
    public void receiveQueue(String text) {
        System.out.println(text);
    }

    @JmsListener(destination = "guid.queue")
    public String receiveGuid(String text) {
        //searching
        System.out.println(GUID);
        return GUID;
    }

    /*@JmsListener(destination = ActiveMQConfig.CHAT_TOPIC, containerFactory = "topicListenerFactory")
    public void receiveChatMessages(Message message) {
        System.out.println("FirstReceiver <" + message + ">");
    }

    @JmsListener(destination = ActiveMQConfig.CHAT_TOPIC, containerFactory = "topicListenerFactory")
    public void receiveMessage(Message message) {
        System.out.println("SecondReceiver <" + message + ">");
    }*/

}

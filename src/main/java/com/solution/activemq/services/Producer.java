package com.solution.activemq.services;

import com.solution.activemq.config.ActiveMQConfig;
import com.solution.activemq.model.Message;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier("simpleQueue")
    private Queue queue;

    @Autowired
    @Qualifier("guidQueue")
    private Queue quidQueue;

    public void sendToQueue(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    public String sendAndReceive(String msg) {
        return this.jmsMessagingTemplate.convertSendAndReceive(quidQueue, msg, String.class);
    }

    public void sendToQueue(String queue, String msg) {
        this.jmsMessagingTemplate.convertAndSend(queue, msg);
    }

   /* public void sendToTopic(String msg) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(ActiveMQConfig.CHAT_TOPIC), new Message("info@example.com", msg));
    }
*/
}

package com.solution.activemq.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import com.solution.activemq.model.Message;
import org.apache.activemq.command.ActiveMQQueue;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@EnableJms
@Configuration
public class ActiveMQConfig  {

    public static final String CHAT_TOPIC = "chat.topic";

    @Bean
    public Queue simpleQueue() {
        return new ActiveMQQueue("simple.queue");
    }

    @Bean
    public Queue guidQueue() {
        return new ActiveMQQueue("guid.queue");
    }

  /*  @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
*/
}

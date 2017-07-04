package com.solution.activemq.test;

import javax.jms.JMSException;

import com.solution.activemq.services.Consumer;
import com.solution.activemq.services.Producer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JMSActiveMQTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private Producer producer;

    @Test
    public void sendToQueueMessage() throws InterruptedException, JMSException {
        this.producer.sendToQueue("Test queue message");
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("Test queue message")).isTrue();
    }

    @Test
    public void sendForGetGuidMessage() throws InterruptedException, JMSException {
        String guid = this.producer.sendAndReceive("Take my guid");
        assertThat(guid).isEqualTo(Consumer.GUID);
    }

   /* @Test
    public void sendToTopicMessage() throws InterruptedException, JMSException {
        this.producer.sendToTopic("Test topic message");
        Thread.sleep(1000L);
        System.out.print(this.outputCapture.toString());
        assertThat(this.outputCapture.toString().contains("FirstReceiver <Message{to=info@example.com, body=Test topic message}>")).isTrue();
        assertThat(this.outputCapture.toString().contains("SecondReceiver <Message{to=info@example.com, body=Test topic message}>")).isTrue();
    }*/

}

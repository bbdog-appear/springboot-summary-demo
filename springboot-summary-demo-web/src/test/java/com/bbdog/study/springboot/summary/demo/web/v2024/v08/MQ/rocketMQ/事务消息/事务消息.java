package com.bbdog.study.springboot.summary.demo.web.v2024.v08.MQ.rocketMQ.事务消息;

import com.bbdog.study.springboot.summary.demo.web.SpringbootSummaryDemoWebApplication;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class 事务消息 extends SpringbootSummaryDemoWebApplication {

    private RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();

    @Test
    public void testSimple() throws Exception {
        Message<String> msg = MessageBuilder.withPayload("延迟消息").build();
        SendResult sendResult = rocketMQTemplate.sendMessageInTransaction("topic_test", msg, null);
        System.out.println("发送结果："+ sendResult);
    }

}

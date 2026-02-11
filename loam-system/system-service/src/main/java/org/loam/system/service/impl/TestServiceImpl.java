package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.loam.system.service.TestService;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public String sendMessage(String message) {

        return  asyncSend(message);
    }


    private String syncSend(String message) {
        rocketMQTemplate.send("test-topic-01", MessageBuilder.withPayload(message).build());
        return "success";
    }

    private String asyncSend(String message) {
        rocketMQTemplate.asyncSend("test-topic-01", MessageBuilder.withPayload(message).build(), new SendCallback(){
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("message send success");
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("message send exception:" + e.getMessage());
            }
        }, 10000L);
        return "success";
    }


    static class CallBack implements SendCallback{

        @Override
        public void onSuccess(SendResult sendResult) {
            System.out.println("message send success");
        }

        @Override
        public void onException(Throwable e) {
            System.out.println("message send exception:" + e.getMessage());
        }
    }

}

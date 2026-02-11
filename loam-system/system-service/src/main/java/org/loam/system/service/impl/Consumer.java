package org.loam.system.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "test-topic-01", consumerGroup = "test-group-01")
public class Consumer implements RocketMQListener<String> {

    private static final Logger log = LogManager.getLogger(Consumer.class);

    @Override
    public void onMessage(String message) {
        log.info("get message: " + message);
    }
}

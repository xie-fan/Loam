package org.loam.system.listener;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

public class TestProducerService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送创建订单的事务消息
     * @param orderPayload 订单的业务数据 (比如 JSON 字符串)
     */
    public void createOrderInTransaction(String orderPayload) {

        String orderId = UUID.randomUUID().toString(); // 模拟生成唯一的订单ID

        // 1. 构造 Spring 的 Message
        Message<String> msg = MessageBuilder.withPayload(orderPayload)
                .setHeader(RocketMQHeaders.KEYS, orderId) // 设置业务KEY，非常重要，用于回查
                .build();

        String destinationTopic = "TOPIC_ORDER_TX"; // 你的消息主题

        // 2. 关键方法: sendMessageInTransaction
        // 第一个参数: 必须和 @RocketMQTransactionListener 注解中的 txProducerGroup 一致
        // 第二个参数: 目标 Topic
        // 第三个参数: 消息体
        // 第四个参数: (arg) 业务参数，会原样传递给 executeLocalTransaction 方法
        System.out.println("准备发送半消息, OrderId: " + orderId);

        this.rocketMQTemplate.sendMessageInTransaction(
                "tx-order-producer-group", // 必须和 Listener 的 txProducerGroup 一致
                destinationTopic,
                msg,
                orderId // 这个 arg 会传递给 executeLocalTransaction
        );

        System.out.println("半消息已发送, OrderId: " + orderId);
    }
}

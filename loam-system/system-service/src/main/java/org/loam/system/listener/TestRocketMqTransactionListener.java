package org.loam.system.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import java.io.BufferedReader;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@RocketMQTransactionListener()
public class TestRocketMqTransactionListener implements RocketMQLocalTransactionListener {

    @Autowired
    private OrderService orderService; // 假设这是你操作数据库的 Service

    // 用于模拟事务状态存储，实际生产中你应该查数据库
    private final Map<String, RocketMQLocalTransactionState> localTransactionState = new ConcurrentHashMap<>();

    /**
     * 1. 执行本地事务 (在发送"半消息"成功后被回调)
     *
     * @param msg "半消息" (对消费者不可见)
     * @param arg 生产者发送消息时传递的业务参数
     * @return 事务状态 (COMMIT, ROLLBACK, UNKNOWN)
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        try {
            // 从 arg 或 msg 中获取你的业务数据
            // 比如，我们在 sendMessageInTransaction 时，arg 传递了 orderId
            String orderId = (String) arg;

            // 假设 msg 的 payload 是订单的 JSON 字符串
            // 注意：这里拿到的 msg 是 Spring 的 Message，不是 RocketMQ 的
            String payload = new String((byte[]) msg.getPayload(), StandardCharsets.UTF_8);
            System.out.println("开始执行本地事务, OrderId: " + orderId + ", Payload: " + payload);

            // ===================================
            // === 这是你的核心业务逻辑（本地事务） ===
            // ===================================
            // 比如：创建订单，并插入数据库
            Order order = createOrderFromPayload(payload); // 假设有个方法解析 payload
            order.setId(orderId);
            orderService.createOrderInDatabase(order); // *** 执行数据库 INSERT ***

            // 事务执行成功
            System.out.println("本地事务执行成功, OrderId: " + orderId);

            // (仅用于回查演示) 记录一下状态
            localTransactionState.put(orderId, RocketMQLocalTransactionState.COMMIT);

            // 告诉 RocketMQ，本地事务成功，可以提交"半消息"了
            return RocketMQLocalTransactionState.COMMIT;

        } catch (Exception e) {
            // 本地事务执行失败
            System.err.println("本地事务执行失败, Error: " + e.getMessage());

            // (仅用于回查演示)
            String orderId = (String) arg;
            localTransactionState.put(orderId, RocketMQLocalTransactionState.ROLLBACK);

            // 告诉 RocketMQ，本地事务失败，请回滚"半消息"
            return RocketMQLocalTransactionState.ROLLBACK;
        }

        /*
        // 3. 状态未知 (UNKNOWN)
        // 什么时候返回 UNKNOWN?
        // 比如你的本地事务执行时间很长，或者你调用的其他服务超时了，你暂时不知道它到底成功了没。
        // 返回 UNKNOWN，RocketMQ 会在稍后发起“回查”。

         String orderId = (String) arg;
         localTransactionState.put(orderId, RocketMQLocalTransactionState.UNKNOW);
         return RocketMQLocalTransactionState.UNKNOW;
        */
    }

    /**
     * 2. 检查本地事务状态 (用于处理 UNKNOWN 状态或Producer宕机)
     *
     * @param msg 生产者发送的原始消息
     * @return 事务状态 (COMMIT, ROLLBACK, UNKNOWN)
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        // RocketMQ 会在 `executeLocalTransaction` 返回 UNKNOWN 或超时未响应时，
        // 定期调用这个方法来"回查"事务的最终状态。

        // 你需要从消息中解析出你的业务ID
        // 最好是在发送时就把业务ID放在 KEY 里
        String orderId = msg.getHeaders().get(RocketMQHeaders.KEYS, String.class);

        if (orderId == null) {
            // 尝试从 payload 解析，这里假设 payload 是 orderId 字符串
            String payload = new String((byte[]) msg.getPayload(), StandardCharsets.UTF_8);
            orderId = payload; // 这只是一个例子，你得按自己的业务规则来
        }

        System.out.println("开始回查本地事务状态, OrderId: " + orderId);

        // ===================================
        // === 查询数据库确认事务状态 ===
        // ===================================
        Order order = orderService.getOrderById(orderId); // *** 查询数据库 ***

        if (order != null && order.getStatus().equals("CREATED")) {
            System.out.println("回查结果：事务已成功 (COMMIT), OrderId: " + orderId);
            return RocketMQLocalTransactionState.COMMIT;
        } else {
            // 如果订单不存在，或者订单状态是“失败”
            System.out.println("回查结果：事务已失败 (ROLLBACK), OrderId: " + orderId);
            return RocketMQLocalTransactionState.ROLLBACK;
        }

        /*
        // 模拟使用我们上面存的 Map (实际生产中千万别这么干)
        RocketMQLocalTransactionState state = localTransactionState.get(orderId);
        System.out.println("回查状态 (from Map): " + state);
        return state != null ? state : RocketMQLocalTransactionState.UNKNOW;
        */
    }

    // 只是一个辅助方法，模拟从消息体解析订单
    private Order createOrderFromPayload(String payload) {
        // 在实际中，你会用 GSON 或 Jackson 来解析 JSON
        // return new Gson().fromJson(payload, Order.class);
        return new Order(); // 假设的订单类
    }

    // 假设的订单类
    static class Order {

        String id;
        String status;
        public void setId(String id) { this.id = id; }
        public String getStatus() { return "CREATED"; } // 假设状态
    }

    // 假设的数据库服务
    @org.springframework.stereotype.Service
    static class OrderService {
        // 模拟插入数据库
        public void createOrderInDatabase(Order order) {
            new BufferedReader();
            System.out.println("[DB] 插入订单成功: " + order.id);
            // 模拟事务失败
            // if (order.id.equals("fail")) {
            //    throw new RuntimeException("数据库插入失败");
            // }
        }

        // 模拟查询数据库
        public Order getOrderById(String orderId) {
            System.out.println("[DB] 查询订单: " + orderId);
            // 模拟查询
            if (localTransactionState.get(orderId) == RocketMQLocalTransactionState.COMMIT) {
                return new Order();
            }
            return null;
        }
    }
}

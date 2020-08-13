package com.example.demolearnamqp.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Slf4j
@Component
public class Send {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 消息发送
     */
    public void sendMessage() {
        //send message synchronously
        rocketMQTemplate.convertAndSend("demodemo", "Hello, World!");
        //send spring message
        rocketMQTemplate.send("demodemo", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        //send messgae asynchronously
        rocketMQTemplate.asyncSend("workorder", new OrderPaidEvent("T_001", new BigDecimal("66.00")), new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) { log.info("success"); }
            @Override
            public void onException(Throwable var1) { log.error("exception"); }
        });
        //Send messages orderly
        rocketMQTemplate.syncSendOrderly("orderly_topic",MessageBuilder.withPayload("Hello, World").build(),"hashkey");
        //rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
    }

    // 消息消费


    @Data
    @AllArgsConstructor
    public static class OrderPaidEvent implements Serializable {
        private String orderId;
        private BigDecimal paidMoney;
    }

}

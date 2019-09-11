package top.flygrk.ishare.springbootkafka.consumer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import top.flygrk.ishare.springbootkafka.consumer.dao.MessageReceiveRepository;
import top.flygrk.ishare.springbootkafka.consumer.entity.MessageReceive;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 13:54
 * @Version: 1.0
 * @Description:
 */

@Component
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private MessageReceiveRepository messageReceiveRepository;

    @KafkaListener(topics = "topic_1")
    public void topicListen(ConsumerRecord<?, ?> record) {
        logger.info("topic = {}, offset = {}, value = {}", record.topic(), record.offset(), record.value());

        try {
            logger.info("Consumer 监听消息数据开始存入mongodb");
            MessageReceive messageReceive = new MessageReceive();
            messageReceive.setId(UUID.randomUUID().toString());
            messageReceive.setConsumeUser("ConsumeUser");
            messageReceive.setConsumeTime(new Date());
            messageReceive.setTopic(record.topic());
            messageReceive.setConsumerOffset(record.offset());
            messageReceive.setMessage(record.value().toString());

            messageReceiveRepository.save(messageReceive);
            logger.info("保存结束！");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("存入mongodb发生异常");
        }


    }


}

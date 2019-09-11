package top.flygrk.ishare.springbootkafka.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flygrk.ishare.springbootkafka.base.Result;
import top.flygrk.ishare.springbootkafka.producer.dao.MessageSendErrorRepository;
import top.flygrk.ishare.springbootkafka.producer.dao.MessageSendRepository;
import top.flygrk.ishare.springbootkafka.producer.entity.MessageSend;
import top.flygrk.ishare.springbootkafka.producer.entity.MessageSendError;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 13:42
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("kafka")
public class ProducerController {
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // 简单写法，直接注入dao层
    @Autowired
    private MessageSendRepository messageSendRepository;

    @Autowired
    private MessageSendErrorRepository messageSendErrorRepository;

    @RequestMapping("send")
    public Result send(String msg) {
        String topic = "topic_1";
        // 封装MessageSend
        MessageSend messageSend = new MessageSend();
        messageSend.setId(UUID.randomUUID().toString());
        messageSend.setProduceTime(new Date());
        messageSend.setProduceUser("ProduceUser");
        messageSend.setTopic(topic);
        messageSend.setMessage(msg);
        try {

            kafkaTemplate.send(topic, msg);
            // 存入mongodb： message_send collection
            try {
                logger.info("开始保存MessageSend");
                messageSendRepository.save(messageSend);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("保存mongodb发生异常！");
                return Result.failure();
            }
        } catch (Exception e) {
            logger.error("发布给kafka主题topic_1时发生异常");
            // 错误信息存储给mongodb message_send_error collection
            MessageSendError messageSendError = new MessageSendError();
            messageSendError.setId(UUID.randomUUID().toString());
            messageSendError.setProduceTime(new Date());
            messageSendError.setProduceUser("ProduceUser");
            messageSendError.setTopic(topic);
            messageSendError.setMessage(msg);
            messageSendError.setResult("发布主题" + topic + "失败");
            try {
                messageSendErrorRepository.save(messageSendError);
            } catch (Exception e1) {
                e1.printStackTrace();
                logger.error("保存mongodb发生异常！");
                return Result.failure();
            }
            return Result.failure();
        }

        return Result.success(messageSend);
    }


}

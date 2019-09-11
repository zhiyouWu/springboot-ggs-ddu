package top.flygrk.ishare.springkafka.handler;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;


/**
 * @Package top.flygrk.ishare.springkafka.handler
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/11 09:56
 * @Version V1.0
 * @Description: 消息结果回调类KafkaSendResultHandler
 */
@Component
public class KafkaSendResultHandler implements ProducerListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaSendResultHandler.class);

    // 消息发送成功，回调onSuccess
    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        logger.info("Message send success: {}", producerRecord.toString());
    }

    // 消息发送失败，回调onError
    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        logger.info("Message send error: {}", producerRecord.toString());
    }
}

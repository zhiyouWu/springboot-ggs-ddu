package top.flygrk.ishare.springkafka.listen;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package top.flygrk.ishare.springkafka.listen
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/11 13:52
 * @Version V1.0
 * @Description:
 */
@Component
public class SingleListener {

    private static final Logger logger = LoggerFactory.getLogger(SingleListener.class);

    @KafkaListener(id = "consumer", topics = "topic.quick.consumer")
    public void consumerListener(ConsumerRecord<Integer, String> record) {
        logger.info("topic.quick.consumer received: {}", record.toString());
    }


}

package top.flygrk.ishare.springkafka.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package top.flygrk.ishare.springkafka.listen
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/10 13:25
 * @Version V1.0
 * @Description: 消费者监听
 */
@Component
public class ConsumerListen {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerListen.class);

    // 声明consumerID为consumer， 监听topicName 为topic.quick.demo的Topic
    @KafkaListener(id = "consumer_data", topics = "topic.quick.demo")
    public void listen(String msgData) {
        logger.info("consumer receive: {}", msgData);
    }

}

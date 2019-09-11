package top.flygrk.ishare.springkafka.listen;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package top.flygrk.ishare.springkafka.listen
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/11 14:04
 * @Version V1.0
 * @Description: 批量消费:
 *      设置的并发量不能大于partition的数量，如果需要提高吞吐量，
 *      可以通过增加partition的数量达到快速提升吞吐量的效果。
 */
@Component
public class BatchListener {

    private static final Logger logger = LoggerFactory.getLogger(BatchListener.class);

    private Map<String, Object> consumerProps() {
        Map <String, Object> props = new HashMap <>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        //一次拉取消息数量
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean("batchContainerFactory")
    public ConcurrentKafkaListenerContainerFactory listenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(new DefaultKafkaConsumerFactory(consumerProps()));

        // 设置并发量， 小于或者等于Topic的分区数
        containerFactory.setConcurrency(5);
        // 设置为批量监听
        containerFactory.setBatchListener(true);
        return containerFactory;
    }

    @Bean
    public NewTopic batchTopic() {
        return new NewTopic("topic.quick.batch", 8, (short) 1);
    }

    @KafkaListener(id = "batch", clientIdPrefix = "batch", topics = {"topic.quick.batch"}, containerFactory = "batchContainerFactory")
    public void batchListener(List<String> data) {
        logger.info("topic.quick.batch  receive : ");
        for (String s : data) {
            logger.info(s);
        }
    }

}

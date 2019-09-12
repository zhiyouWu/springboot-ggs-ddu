package top.flygrk.ishare.springkafka.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Package top.flygrk.ishare.springkafka.listen
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/12 11:16
 * @Version V1.0
 * @Description:
 */
@Component
public class AnnoListener {
    private static final Logger logger = LoggerFactory.getLogger(AnnoListener.class);

    @KafkaListener(id = "anno", topics = "topic.quick.anno")
    public void annoListener(@Payload String data,
                             @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
        logger.info("topic.quick.anno receive : \n"+
                "data : "+data+"\n"+
                "key : "+key+"\n"+
                "partitionId : "+partition+"\n"+
                "topic : "+topic+"\n"+
                "timestamp : "+ts+"\n"
        );
    }

}

package top.flygrk.ishare.springkafka.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package top.flygrk.ishare.springkafka.test
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/12 11:20
 * @Version V1.0
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnoTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testAnno() throws InterruptedException {
        Map map = new HashMap<>();
        map.put(KafkaHeaders.TOPIC, "topic.quick.anno");
        map.put(KafkaHeaders.MESSAGE_KEY, 0);
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.TIMESTAMP, System.currentTimeMillis());

        kafkaTemplate.send(new GenericMessage<>("test anno listener", map));
    }
}

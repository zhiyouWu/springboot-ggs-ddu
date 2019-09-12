package top.flygrk.ishare.springkafka.test;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.flygrk.ishare.springkafka.handler.KafkaSendResultHandler;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Package top.flygrk.ishare.springkafka.test
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/10 13:29
 * @Version V1.0
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private AdminClient adminClient;

    @Resource
    private KafkaTemplate defaultKafkaTemplate;

    @Autowired
    private KafkaSendResultHandler kafkaSendResultHandler;

    @Test
    public void testProducer() throws InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "This is my first kafka demo");
        Thread.sleep(3000);
    }


    @Test
    public void testCreateTopic() throws InterruptedException {
        NewTopic newTopic = new NewTopic("topic.quick.initial2", 1, (short) 1);
        adminClient.createTopics(Arrays.asList(newTopic));
        Thread.sleep(1000);
    }

    @Test
    public void testSelectTopicInfo() throws ExecutionException, InterruptedException {
        DescribeTopicsResult result = adminClient.describeTopics(Arrays.asList("topic.quick.initial"));
        result.all().get().forEach((k,v) -> System.out.println("k: " + k + " ,v: " + v.toString() + "\n"));
    }

    @Test
    public void testDefaultKafkaTemplate() {
        defaultKafkaTemplate.sendDefault("I`m send msg to default topic");
    }

    @Test
    public void testKafkaTemplateSend() {
        // 发送带有时间戳的消息
        kafkaTemplate.send("topic.quick.demo", 0,  System.currentTimeMillis(), 0, "send message with timestamp");

        // 使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord("topic.quick.demo", "use ProducerRecord to send message");
        kafkaTemplate.send(record);

        // 使用message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, "topic.quick.demo");
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, 0);
        GenericMessage message = new GenericMessage("use Message to send message", new MessageHeaders(map));
        kafkaTemplate.send(message);

    }


    @Test
    public void testProducerListen() throws InterruptedException {
        kafkaTemplate.setProducerListener(kafkaSendResultHandler);
        kafkaTemplate.send("topic.quick.demo", "test producer listen");
        Thread.sleep(1000);
    }

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "test sync send message").get();
    }

    @Test
    public void testSyncSendWithTimeout() throws ExecutionException, InterruptedException, TimeoutException {
        kafkaTemplate.send("topic.quick.demo", "test sync with timeout send message").get(1, TimeUnit.MICROSECONDS);
    }

    @Test
    @Transactional
    public void testTransaction() {
        kafkaTemplate.send("topic.quick.demo", "test transactional annotation");
        throw new RuntimeException("fail");
    }

    @Test
    public void testExecuteInTransaction() {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send("topic.quick.tran", "test executeInTransaction");
                throw new RuntimeException("fail");
            }
        });
    }

    @Test
    @Transactional
    public void testBean() {
        kafkaTemplate.send("topic.quick.bean", "send message to beanListener");
    }


    @Test
    public void testConsumerRecord() {
        kafkaTemplate.send("topic.quick.consumer", "test receive by consumerRecord");
    }

    @Test
    public void testBatch() {
        for (int i = 0; i < 12; i++) {
            kafkaTemplate.send("topic.quick.batch", "test batch listener, dataNum-" + i);
        }
    }

    @Test
    public void testBatchWithPartition() {
        for (int i = 0; i < 12; i++) {
            kafkaTemplate.send("topic.quick.batch.partition", "test batch partition listener, dataNum-" + i);
        }
    }


}

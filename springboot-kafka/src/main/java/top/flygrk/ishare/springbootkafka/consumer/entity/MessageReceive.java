package top.flygrk.ishare.springbootkafka.consumer.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 14:40
 * @Version: 1.0
 * @Description:
 */
@Data
@Document("message_receive")
public class MessageReceive {

    private String id;

    @Field("consume_user")
    private String consumeUser;

    private String message;

    @Field("consume_time")
    private Date consumeTime;

    @Field("consume_offset")
    private long consumerOffset;

    private String topic;

}

package top.flygrk.ishare.springbootkafka.producer.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 14:57
 * @Version: 1.0
 * @Description:
 */
@Data
@Document("message_send_error")
public class MessageSendError {
    @Field("produce_user")
    private String produceUser;

    @Field("produce_time")
    private Date produceTime;

    private String message;

    private String id;

    private String topic;

    private String result;
}

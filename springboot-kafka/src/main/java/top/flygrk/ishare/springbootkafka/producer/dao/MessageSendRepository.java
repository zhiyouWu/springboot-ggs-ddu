package top.flygrk.ishare.springbootkafka.producer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.flygrk.ishare.springbootkafka.producer.entity.MessageSend;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 14:25
 * @Version: 1.0
 * @Description:
 */
@Repository
public interface MessageSendRepository extends MongoRepository<MessageSend, String> {
}

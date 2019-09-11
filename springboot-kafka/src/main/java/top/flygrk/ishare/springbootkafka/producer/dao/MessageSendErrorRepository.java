package top.flygrk.ishare.springbootkafka.producer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.flygrk.ishare.springbootkafka.producer.entity.MessageSendError;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 14:59
 * @Version: 1.0
 * @Description:
 */
@Repository
public interface MessageSendErrorRepository extends MongoRepository<MessageSendError, String> {
}

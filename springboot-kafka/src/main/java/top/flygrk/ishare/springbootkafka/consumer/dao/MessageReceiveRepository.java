package top.flygrk.ishare.springbootkafka.consumer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.flygrk.ishare.springbootkafka.consumer.entity.MessageReceive;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/5 14:40
 * @Version: 1.0
 * @Description:
 */
@Repository
public interface MessageReceiveRepository extends MongoRepository<MessageReceive, String> {
}

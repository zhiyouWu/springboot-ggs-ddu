package top.flygrk.ishare.springbootmongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.flygrk.ishare.springbootmongodb.entity.Example;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 10:42
 * @Version: 1.0
 * @Description:
 */
@Repository
public interface ExampleRepository extends MongoRepository<Example, String> {
}

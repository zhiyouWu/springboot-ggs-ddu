package top.flygrk.ishare.springbootmongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.flygrk.ishare.springbootmongodb.entity.Log;

import java.util.Date;
import java.util.List;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 11:07
 * @Version: 1.0
 * @Description:
 */
@Repository
public interface LogRepository extends MongoRepository<Log, String> {

    List<Log> findByUserId(Long userId);

    List<Log> findByCreateTimeBetween(Date startTime, Date endTime);

    Page<Log> findByCreateTimeBetween(Date startTime, Date endTime, Pageable pageable);

}

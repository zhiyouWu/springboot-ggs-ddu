package top.flygrk.ishare.springbootmongodb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.flygrk.ishare.springbootmongodb.entity.Log;

import java.util.Date;
import java.util.List;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 11:09
 * @Version: 1.0
 * @Description:
 */
public interface LogService {

    List<Log> findByUserId(Long userId);

    List<Log> findByCreateTimeBetween(Date startTime, Date endTime);

    Page<Log> findByCreateTimeBetween(Date startTime, Date endTime, Pageable pageable);

    Log save(Log log);

    Log deleteByUserId(String userId);

}

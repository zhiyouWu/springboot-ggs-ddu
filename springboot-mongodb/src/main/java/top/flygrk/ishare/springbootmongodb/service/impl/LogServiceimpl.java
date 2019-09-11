package top.flygrk.ishare.springbootmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.flygrk.ishare.springbootmongodb.dao.LogRepository;
import top.flygrk.ishare.springbootmongodb.entity.Log;
import top.flygrk.ishare.springbootmongodb.service.LogService;

import java.util.Date;
import java.util.List;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 11:11
 * @Version: 1.0
 * @Description:
 */
@Service
public class LogServiceimpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> findByUserId(Long userId) {

        return null;
    }

    @Override
    public List <Log> findByCreateTimeBetween(Date startTime, Date endTime) {
        return null;
    }

    @Override
    public Page<Log> findByCreateTimeBetween(Date startTime, Date endTime, Pageable pageable) {

        int pageNo = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize == 0 ? 10 : pageSize);
        Page<Log> logPage = logRepository.findByCreateTimeBetween(startTime, endTime, pageRequest);

        return logPage;
    }

    @Override
    public Log save(Log log) {

        return logRepository.save(log);

    }

    @Override
    public Log deleteByUserId(String userId) {
        return null;
    }


}

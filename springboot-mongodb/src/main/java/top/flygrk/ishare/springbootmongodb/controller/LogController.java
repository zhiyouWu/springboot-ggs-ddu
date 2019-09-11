package top.flygrk.ishare.springbootmongodb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import top.flygrk.ishare.springbootmongodb.entity.Log;
import top.flygrk.ishare.springbootmongodb.service.LogService;
import top.flygrk.ishare.springbootmongodb.vo.LogVO;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 11:11
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/log")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Log save(@RequestBody Log log) {
        return logService.save(log);
    }

    @RequestMapping(value = "/findByTime")
    public Page<Log> findByTime(LogVO logVO) {
        if (logVO == null || logVO.getCreateStart() == null) {
            logger.error("查询失败！ reason: 传入的必要信息为null");
            return null;
        }

        Pageable pageable = PageRequest.of(logVO.getPageNo(), logVO.getCreateEnd() == null ? 10 : logVO.getPageSize());

        return logService.findByCreateTimeBetween(
                logVO.getCreateTime(),
                logVO.getCreateEnd() == null ? new Date() : logVO.getCreateEnd(),
                pageable);
    }

}

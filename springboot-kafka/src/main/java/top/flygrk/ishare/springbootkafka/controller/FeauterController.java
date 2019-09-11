package top.flygrk.ishare.springbootkafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/31 09:11
 * @Version: 1.0
 * @Description:
 */

@RestController
public class FeauterController {
    private static final Logger logger = LoggerFactory.getLogger(FeauterController.class);

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(String msg, Date date) {
        logger.info("====  received: msg = {}, date = {}", msg, date);
        return "Hello" + msg;
    }

}
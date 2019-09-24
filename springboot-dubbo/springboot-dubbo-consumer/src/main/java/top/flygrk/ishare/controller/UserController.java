package top.flygrk.ishare.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flygrk.ishare.service.UserService;

/**
 * @Package top.flygrk.ishare.controller
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/23 13:42
 * @Version V1.0
 * @Description:
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Reference
    private UserService userService;

    @GetMapping("sayHello")
    public String sayHello() {
        logger.info("sayHello()接口返回内容： {}", userService.sayHello());
        return userService.sayHello();
    }

}

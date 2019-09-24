package top.flygrk.ishare.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.flygrk.ishare.service.UserService;

/**
 * @Package top.flygrk.ishare.service.impl
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/23 11:25
 * @Version V1.0
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello() {
        return "Hello World";
    }
}

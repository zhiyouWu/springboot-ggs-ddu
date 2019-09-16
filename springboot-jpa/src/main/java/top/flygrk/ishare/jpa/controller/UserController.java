package top.flygrk.ishare.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.flygrk.ishare.jpa.dao.UserJPA;
import top.flygrk.ishare.jpa.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @Package top.flygrk.ishare.controller
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/16 15:07
 * @Version V1.0
 * @Description: user接口
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> list() {
        return userJPA.findAll();
    }

    /**
     * 保存用户
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userJPA.save(user);
    }

    /**
     * 查找用户
     * @param id
     * @return
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public User find(Long id) {
        Optional<User> optionalUser = userJPA.findById(id);
        if (optionalUser.isPresent()) {
            return userJPA.findById(id).get();
        }
        return null;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public List<User> delete(Long id) {
        if (this.find(id) != null) {
            userJPA.deleteById(id);
        }
        return this.list();
    }

}

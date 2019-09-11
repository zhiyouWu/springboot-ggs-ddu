package top.flygrk.ishare.springbootswagger.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.flygrk.ishare.springbootswagger.entity.User;

/**
 * @Package top.flygrk.ishare.springbootswagger.controller
 * @Author wuzy
 * @Date 2019/8/5 11:07
 * @Version V1.0
 * @Description: 用户接口
 */
@RestController
@RequestMapping("user")
@Api("用户管理模块")
public class UserController {
    /**
    * @Authod wuzy
    * @Date 2019/8/5 11:09
    * @Method insert
    * @Param    user
    * @ReturnType String
    * @Description: 插入用户信息
    */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ApiOperation(value = "插入用户信息", notes = "插入用户的详细信息")
    public Object insert(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("result", "failed");
            jsonObject.put("reason", "user is null");
            return jsonObject;
        }
        jsonObject.put("result", "success");
        jsonObject.put("msg", user.getUsername());
        return jsonObject;
    }

    @RequestMapping(value = "findById", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息", notes = "根据id查询用户信息")
    public Object findById(@ApiParam(value = "用户id", required = true) String id) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(id)) {
            jsonObject.put("result", "failed");
            jsonObject.put("reason", "user is null");
            return jsonObject;
        }
        jsonObject.put("id", id);
        jsonObject.put("username", "wuzy");
        jsonObject.put("age", 20);
        jsonObject.put("note", "coding boy");
        return jsonObject;
    }

}

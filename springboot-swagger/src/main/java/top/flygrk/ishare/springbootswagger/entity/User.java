package top.flygrk.ishare.springbootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package top.flygrk.ishare.springbootswagger.entity
 * @Author wuzy
 * @Date 2019/8/5 11:05
 * @Version V1.0
 * @Description:
 */
@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "用户id", required = true, dataType = "String")
    private String id;
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;
    @ApiModelProperty(value = "年纪", dataType = "int")
    private int age;
    @ApiModelProperty(value = "备注", dataType = "String")
    private String note;
}

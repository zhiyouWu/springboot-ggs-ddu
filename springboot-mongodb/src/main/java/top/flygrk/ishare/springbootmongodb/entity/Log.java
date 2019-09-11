package top.flygrk.ishare.springbootmongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 10:53
 * @Version: 1.0
 * @Description:
 */
@Document
@Data
public class Log {

    private String id;

    @Field("user_id")
    private String userId;

    private int type;

    private String desc;

    @Field("create_time")
    private Date createTime;

}

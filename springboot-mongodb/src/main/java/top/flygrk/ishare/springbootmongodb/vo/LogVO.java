package top.flygrk.ishare.springbootmongodb.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 14:11
 * @Version: 1.0
 * @Description:
 */
@Data
public class LogVO extends CommonVO {

    private String userId;

    private int type;

    private String desc;

}

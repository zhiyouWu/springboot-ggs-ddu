package top.flygrk.ishare.springbootmongodb.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 14:12
 * @Version: 1.0
 * @Description:
 */
@Data
public class CommonVO {

    private String id;

    private Date createTime;

    private int pageNo;

    private int pageSize;

    private Date createStart;

    private Date createEnd;

}

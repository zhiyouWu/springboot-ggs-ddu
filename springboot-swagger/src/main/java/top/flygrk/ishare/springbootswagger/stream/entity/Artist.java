package top.flygrk.ishare.springbootswagger.stream.entity;

import lombok.Data;

/**
 * @Package top.flygrk.ishare.springbootswagger.stream.entity
 * @Author wuzy@watone.com.cn
 * @Date 2019/8/6 10:33
 * @Version V1.0
 * @Description:
 */
@Data
public class Artist {
    private String name;
    private String from;

    public boolean isFrom(String from) {
        return this.from == from;
    }
}

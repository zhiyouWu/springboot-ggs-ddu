package top.flygrk.ishare.springbootmongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: flygrk
 * @Date: Created in 2019/7/4 10:41
 * @Version: 1.0
 * @Description:
 */
@Document
public class Example {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

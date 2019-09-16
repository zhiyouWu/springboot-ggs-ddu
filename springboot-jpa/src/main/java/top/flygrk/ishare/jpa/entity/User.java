package top.flygrk.ishare.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Package top.flygrk.ishare.entity
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/16 14:49
 * @Version V1.0
 * @Description:
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

}

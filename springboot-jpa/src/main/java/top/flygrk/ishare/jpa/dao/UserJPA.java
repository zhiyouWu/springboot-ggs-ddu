package top.flygrk.ishare.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.flygrk.ishare.jpa.entity.User;

import java.io.Serializable;

/**
 * @Package top.flygrk.ishare.dao
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/16 15:11
 * @Version V1.0
 * @Description: user jpa
 *     JpaRepository:               SpringDataJPA提供的简单数据操作接口
 *     JpaSpecificationExecutor:    SpringDataJPA提供的复杂查询接口
 *     Serializable:                序列化接口
 */
public interface UserJPA extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, Serializable {
}

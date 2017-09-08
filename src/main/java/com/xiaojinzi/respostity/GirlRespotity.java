package com.xiaojinzi.respostity;

import com.xiaojinzi.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 数据库映射采用jpa
 * 其中继承jpa * Created by JQ on 2017/9/6.
 中key分别为表名和主键类型
 */
public interface GirlRespotity extends JpaRepository<Girl,Integer>{

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}

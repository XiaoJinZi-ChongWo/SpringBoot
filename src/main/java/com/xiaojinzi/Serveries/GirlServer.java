package com.xiaojinzi.Serveries;

import com.xiaojinzi.Exception.GirlException;
import com.xiaojinzi.enums.ResultEnum;
import com.xiaojinzi.respostity.GirlRespotity;
import com.xiaojinzi.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 业务层
 * Created by JQ on 2017/9/6.
 */
@Service
public class GirlServer {

    @Autowired
    private GirlRespotity girlRespotity;

    /**
     * 事物注解方式
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(15);
        girlA.setName("小新");

        girlRespotity.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(15);
        girlB.setName("小新");

        girlRespotity.save(girlB);
    }

    /**
     * 义务逻辑处理
     * @param id
     * @throws Exception
     */
    public void checkAge(Integer id) throws Exception{
        Girl girl = girlRespotity.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMAY_SCHOOL);
        }else if(age > 10 && age < 16){
            throw new GirlException(ResultEnum.HIGH_SCHOOL);
        }
    }

    /**
     * 测试
     * @param id
     * @return
     */
    public Girl findOneGirl(Integer id){
       return girlRespotity.findOne(id);
    }

}

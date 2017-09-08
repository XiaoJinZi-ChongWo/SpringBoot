package com.xiaojinzi;

import com.xiaojinzi.Serveries.GirlServer;
import com.xiaojinzi.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Service 测试
 * Created by JQ on 2017/9/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlServer girlServer;

    @Test
    public void findOneGirl(){
       Girl girl = girlServer.findOneGirl(3);
       Assert.assertEquals(new Integer(18),girl.getAge());
    }
}

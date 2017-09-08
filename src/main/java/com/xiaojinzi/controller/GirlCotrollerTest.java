package com.xiaojinzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JQ on 2017/9/6.
 * 带视图返回的Controller层
 */

@Controller
public class GirlCotrollerTest {

    /**
     * value 同时可以用集合的方式保证能够两种url请求访问同一个方法
     * @return
     */
    @RequestMapping(value={"/hellotemplates","/hi"},method = RequestMethod.GET)
    public String say(){
        return "index";
    }
}

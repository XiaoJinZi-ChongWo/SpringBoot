package com.xiaojinzi.util;


import com.xiaojinzi.domain.Result;
import com.xiaojinzi.enums.ResultEnum;

/**
 * http返回工具集配置
 * Created by JQ on 2017/9/7.
 */
public class ResultUtil {

    /** 成功返回*/
    public static Result success(ResultEnum resultEnum,Object object){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    /** 错误返回*/
    public static Result erro(Integer code,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(object.toString());
        return result;
    }
}

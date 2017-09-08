package com.xiaojinzi.Exception;

import com.xiaojinzi.enums.ResultEnum;

/**
 * Created by JQ on 2017/9/7.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

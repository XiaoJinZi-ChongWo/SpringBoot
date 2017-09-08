package com.xiaojinzi.domain;

/**
 * http返回内容封装
 * Created by JQ on 2017/9/7.
 */
public class Result<T> {

    /** 编号*/
    private Integer code;
    /** 信息*/
    private String msg;
    /** 内容*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

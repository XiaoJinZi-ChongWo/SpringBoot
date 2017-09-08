package com.xiaojinzi.enums;

/**
 * 异常码
 * Created by JQ on 2017/9/7.
 */
public enum ResultEnum {
    SUCCESS(0,"成功"),
    SYS_ERRO(1,"系统异常"),
    PRIMAY_SCHOOL(100,"上小学"),
    HIGH_SCHOOL(101,"上高中"),

    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

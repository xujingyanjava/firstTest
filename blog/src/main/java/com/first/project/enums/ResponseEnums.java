package com.first.project.enums;

/**
 * 返回枚举类
 */
public enum ResponseEnums {

    /**
     * 成功
     */
    SUCCESS("成功",0),
    /**
     * 失败
     */
    FAIL("失败",1001),
    /**
     * 用户账号或者密码有误
     */
    USER_ACCOUNT_ERROR ("用户账号或者密码有误",1002);

    private String msg;

    private int Code;

    ResponseEnums(String msg, int code) {
        this.msg = msg;
        Code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}

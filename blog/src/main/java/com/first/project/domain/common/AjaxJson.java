package com.first.project.domain.common;


import java.io.Serializable;

public class AjaxJson implements Serializable {

    private static final long serialVersionUID = 8901301904839272527L;

    private boolean success = true;

    private String msg = "操作成功";

    private Object obj = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

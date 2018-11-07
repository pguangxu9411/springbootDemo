package com.gg.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * JSON返回结果工具类
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResponseUtil {
    private int no;//代码
    private String msg;//正确/错误消息
    private Object obj;//返回值

    @Override
    public String toString() {
        return "{" +
                "no=" + no +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public ResponseUtil(int no, String msg, Object obj) {
        this.no = no;
        this.msg = msg;
        this.obj = obj;
    }

    public ResponseUtil(int no, String msg) {
        this.no = no;
        this.msg = msg;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Integer ID;

    private String username;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date createDate;

    private String method;

    private String result;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Log{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", createDate=" + createDate +
                ", method='" + method + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Log() {

    }

    public Log(Integer ID, String username, Date createDate, String method, String result) {

        this.ID = ID;
        this.username = username;
        this.createDate = createDate;
        this.method = method;
        this.result = result;
    }
}
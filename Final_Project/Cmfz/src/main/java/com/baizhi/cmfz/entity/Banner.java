package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Banner implements Serializable{
    private Integer ID;
    private String title;
    private String url;
    private String status;
    @JSONField(format = "yyyy/MM/dd")
    private Date createDate;
    private String description;

    @Override
    public String toString() {
        return "Banner{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Banner() {

    }

    public Banner(Integer ID, String title, String url, String status, Date createDate, String description) {

        this.ID = ID;
        this.title = title;
        this.url = url;
        this.status = status;
        this.createDate = createDate;
        this.description = description;
    }
}

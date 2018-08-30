package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {
    private Integer ID;

    private String title;

    private String url;

    private Double size;

    private Integer duration;
    @JSONField(format = "yyyy/MM/dd")
    private Date createDate;

    private String albumId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Chapter{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", createDate=" + createDate +
                ", albumId='" + albumId + '\'' +
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Chapter() {

    }

    public Chapter(Integer ID, String title, String url, Double size, Integer duration, Date createDate, String albumId) {

        this.ID = ID;
        this.title = title;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.createDate = createDate;
        this.albumId = albumId;
    }
}
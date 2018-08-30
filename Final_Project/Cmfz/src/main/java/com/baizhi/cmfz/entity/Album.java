package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {
    private String ID;

    private String title;

    private Double score;

    private String author;

    private String broadcast;//播音员

    private Integer count;//评分

    private String brief;//内容介绍
    @JSONField(format = "yyyy/MM/dd")
    private Date publishDate;//发布日期

    private String coverImg;//封面图片

    private String status;
    @JSONField(format = "yyyy/MM/dd")
    private Date createDate;//创建日期

    private List<Chapter> children;//包含的章节

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Album{" +
                "id='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", count=" + count +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", coverImg='" + coverImg + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", children=" + children +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
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

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Album() {

    }

    public Album(String ID, String title, Double score, String author, String broadcast, Integer count, String brief, Date publishDate, String coverImg, String status, Date createDate, List<Chapter> children) {

        this.ID = ID;
        this.title = title;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.count = count;
        this.brief = brief;
        this.publishDate = publishDate;
        this.coverImg = coverImg;
        this.status = status;
        this.createDate = createDate;
        this.children = children;
    }
}

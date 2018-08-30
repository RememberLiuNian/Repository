package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Menu implements Serializable{
    private Integer ID;
    private String title;
    private String content;
    private String href;
    private String iconCls;
    private Integer parntID;

    public Menu() {

    }

    public Menu(Integer ID, String title, String content, String href, String iconCls, Integer parntID) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.parntID = parntID;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParntID() {
        return parntID;
    }

    public void setParntID(Integer parntID) {
        this.parntID = parntID;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parntID=" + parntID +
                '}';
    }
}

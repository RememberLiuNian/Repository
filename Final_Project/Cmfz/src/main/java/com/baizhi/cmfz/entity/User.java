package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer ID;
    private String name;
    private String photoImg;
    private String dharamName;
    private String sex;
    private String province;
    private String city;
    private String signs;
    private String phoneNum;
    private String password;
    private String salt;
    private Integer status;
    private Date registDate;

    public User() {
    }

    public User(Integer ID, String name, String photoImg, String dharamName, String sex, String province, String city, String signs, String phoneNum, String password, String salt, Integer status, Date registDate) {
        this.ID = ID;
        this.name = name;
        this.photoImg = photoImg;
        this.dharamName = dharamName;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.signs = signs;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.registDate = registDate;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    public String getDharamName() {
        return dharamName;
    }

    public void setDharamName(String dharamName) {
        this.dharamName = dharamName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSigns() {
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", photoImg='" + photoImg + '\'' +
                ", dharamName='" + dharamName + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", signs='" + signs + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", registDate=" + registDate +
                '}';
    }
}

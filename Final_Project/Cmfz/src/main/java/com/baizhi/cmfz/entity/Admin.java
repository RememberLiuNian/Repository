package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer ID;
    private String name;
    private String password;

    public Admin() {
    }

    public Admin(Integer ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

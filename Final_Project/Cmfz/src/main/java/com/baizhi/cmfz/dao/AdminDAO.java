package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;

import java.util.List;

public interface AdminDAO {
    public void insert(Admin admin);
    public List<Admin> queryAll();
}

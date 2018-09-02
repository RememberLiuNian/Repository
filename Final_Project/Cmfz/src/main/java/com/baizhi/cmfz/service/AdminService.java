package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;

import java.util.List;

public interface AdminService {
    public void insert(Admin admin);
    public List<Admin> queryAll();

}

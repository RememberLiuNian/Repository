package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;

import java.util.List;

public interface UserDAO {
    public void insert(User user);
    public List<User> queryAll();
}

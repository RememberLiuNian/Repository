package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.User;

import java.util.List;

public interface UserService {
    public void insert(User user);
    public List<User> queryAll();

}

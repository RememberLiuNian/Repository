package com.baizhi.cmfz.service.impl;


import com.baizhi.cmfz.dao.UserDAO;
import com.baizhi.cmfz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {
    @Autowired
    private UserDAO dao;

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void insert(User user){
        dao.insert(user);
    }
    public List<User> queryAll(){
        return dao.queryAll();
    }

}

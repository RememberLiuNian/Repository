package com.baizhi.cmfz.service.impl;


import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl {
    @Autowired
    private AdminDAO dao;

    public AdminDAO getDao() {
        return dao;
    }

    public void setDao(AdminDAO dao) {
        this.dao = dao;
    }

    public void insert(Admin admin){
        dao.insert(admin);
    }
    public List<Admin> queryAll(){
        return dao.queryAll();
    }

}

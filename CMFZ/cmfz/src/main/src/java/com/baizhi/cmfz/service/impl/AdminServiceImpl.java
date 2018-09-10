package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Override
    public Admin modifyQueryByNameAndPassword(String name, String password) {

        return adminDAO.qureyAdminByNameAndPassword(name,password);
    }

    @Override
    public Admin modifyQueryByname(String name) {
        return adminDAO.queryAdminByname(name);
    }
}

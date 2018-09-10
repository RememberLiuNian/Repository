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
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDAO dao;

    //登陆验证
    @Override
    public void loginVerify(Admin admin) {
        System.out.println(admin);
        Admin admin2 = dao.selectAdminByNameAndPassword(admin.getName(),admin.getPassword());
        System.out.println(3);
        System.out.println(admin2);
        if (admin2==null){
            throw new RuntimeException("账号或密码错误");
        }else{
            admin.setID(admin2.getID());
        }
    }
}

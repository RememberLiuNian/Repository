package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;

    public AdminService getService() {
        return service;
    }

    public void setService(AdminService service) {
        this.service = service;
    }

    @RequestMapping("/regist")
    public String insert(Admin admin){
        service.insert(admin);
        return "index";
    }
}

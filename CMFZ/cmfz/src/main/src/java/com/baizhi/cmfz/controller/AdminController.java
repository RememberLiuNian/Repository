package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public @ResponseBody boolean login(Admin admin, HttpSession session) {
        boolean b = true;
        try{
            adminService.modifyQueryByNameAndPassword(admin.getName(),admin.getPassword());
            session.setAttribute("admin",admin);
        }catch (Exception e){
            b=false;
        }
        return b;
    }

}

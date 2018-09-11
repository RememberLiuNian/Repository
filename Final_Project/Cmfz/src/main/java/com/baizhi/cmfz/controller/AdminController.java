package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
@Qualifier
public class AdminController {
    @Autowired
    private AdminService adminService;
    //登陆验证
    @RequestMapping("/login")
    public @ResponseBody
    boolean login(Admin admin, HttpSession session){
        boolean b = true;
        try {
            adminService.loginVerify(admin);
            System.out.println(admin);
            //不出异常，登陆成功，将用户存入session中
            session.setAttribute("admin",admin);
            System.out.println(1);
        } catch (Exception e) {
            b = false;
            System.out.println(2);
        }
        return b;
    }
    //登出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/cmfz/login.jsp";

    }
}

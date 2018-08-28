package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping("/regist")
    public String insert(User user){
        service.insert(user);
        return "index";
    }
}

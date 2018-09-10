package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

public interface AdminService {
    public Admin modifyQueryByNameAndPassword(String name,String password);
    public Admin modifyQueryByname(String name);

}

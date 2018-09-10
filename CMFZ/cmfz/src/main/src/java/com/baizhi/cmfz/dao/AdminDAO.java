package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    //根据名字和ID查询
    public Admin qureyAdminByNameAndPassword(@Param(value = "name")String name,@Param(value = "password")String password);
    //根据名字查询
    public Admin queryAdminByname(String name);

}

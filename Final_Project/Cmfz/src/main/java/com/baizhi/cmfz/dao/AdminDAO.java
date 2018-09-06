package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDAO {
    //查询根据用户名和密码
    Admin selectAdminByNameAndPassword(@Param(value ="name") String name,@Param(value = "password") String password);
    //根据用户名查询
    Admin selectAdminByUsername(String name);
}

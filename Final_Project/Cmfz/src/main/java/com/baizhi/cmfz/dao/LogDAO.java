package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDAO {
    void deleteById(Integer id);

    void insertLog(Log record);

    Log selectById(Integer id);

    void updateById(Log record);
    //分页展示日志信息
    List<Log> selectLogByPage(@Param("start") int start, @Param("page") int page);
    //总条数
    int selectCount();
}
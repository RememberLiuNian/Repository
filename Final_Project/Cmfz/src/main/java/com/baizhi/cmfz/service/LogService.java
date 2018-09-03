package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * Created by SK on 2018/8/5.
 */
public interface LogService {
    //分页展示
    Map getLogByPage(int rows, int page);
    //插入
    public void addLog(Log log);
}

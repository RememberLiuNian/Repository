package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    //分页展示
    @Override
    public Map getLogByPage(int rows, int page) {
        int start = (page-1)*rows;
        int page2 = rows;
        List<Log> list =  logDao.selectLogByPage(start,page2);
        int total = logDao.selectCount();
        Map map = new HashMap();

        map.put("rows",list);
        map.put("total",total);

        return map;
    }

    //插入一条日志信息
    @Override
    public void addLog(Log log){
        logDao.insertLog(log);
    }
}

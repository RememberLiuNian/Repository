package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO dao;

    public MenuDAO getDao() {
        return dao;
    }

    public void setDao(MenuDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Menu> queryMenu(){
        return dao.queryMenu();
    }
}

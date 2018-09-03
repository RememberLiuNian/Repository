package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.aspect.LogAnnotation;
import com.baizhi.cmfz.dao.BannerDAO;
import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SK on 2018/7/31.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDAO bannerDao;
    //分页展示
    @Override
    public Map getBannerByPage(int rows, int page) {
        int start = (page-1)*rows;
        int page2 = rows;
        List<Banner> list = bannerDao.selectBannerByPage(start,page2);
        int count = bannerDao.selectCount();
        Map map = new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }
    //删除
    @Override
    @LogAnnotation(name="删除轮播图")
    public void removeBanner(Banner banner) {
        Banner ba = bannerDao.selectBannerById(banner.getID());
        bannerDao.deleteBanner(banner.getID());
        banner.setUrl(ba.getUrl());
    }
    //添加
    @Override
    @LogAnnotation(name="添加轮播图")
    public void appendBanner(Banner banner) {
        banner.setStatus("Y");
        banner.setCreateDate(new Date());
        bannerDao.insertBanner(banner);
    }
    //修改图片状态
    @Override
    @LogAnnotation(name="修改轮播图展示状态")
    public void modifyBanner(Banner banner) {
        bannerDao.updateBanner(banner);
    }
}

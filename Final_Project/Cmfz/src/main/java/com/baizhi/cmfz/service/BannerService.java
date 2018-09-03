package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Banner;

import java.util.Map;

/**
 * Created by SK on 2018/7/31.
 */
public interface BannerService {
    //分页查询图片轮播
    Map getBannerByPage(int rows, int page);
    //删除指定图片记录
    void removeBanner(Banner banner);
    //添加图片
    void appendBanner(Banner banner);
    //修改图片状态
    void modifyBanner(Banner banner);
}

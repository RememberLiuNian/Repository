package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO {
    //分页查询图片
    List<Banner> selectBannerByPage(@Param("start") int start, @Param("page") int page);
    //查询所有条数
    int selectCount();
    //删除指定图片
    void deleteBanner(int id);
    //添加图片
    void insertBanner(Banner banner);
    //修改图片状态
    void updateBanner(Banner banner);
    //根据id查询
    Banner selectBannerById(int id);
    //查询所有需要展示的图片
    List<Banner> selectBannerByStatus();
}

package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    //分页展示轮播图片信息
    @RequestMapping("/getBanners")
    public @ResponseBody  Map getBanners(int rows,int page){
        return bannerService.getBannerByPage(rows, page);
    }

    //删除指定轮播图片
    @RequestMapping("/deleteBanner")
    public @ResponseBody boolean deleteBanner(int id,HttpServletRequest request){
        Banner banner = new Banner();
        banner.setID(id);
        try {
            bannerService.removeBanner(banner);
            String path = request.getRealPath("tabs");
            File file = new File(path+banner.getUrl());
            file.delete();

            return true;
        } catch (Exception e) {
            return false;
        }
    }



    //添加轮播图片
    @RequestMapping("/addBanner")
    public @ResponseBody  boolean addBanner(MultipartFile photo, Banner banner, HttpServletRequest request){
        //获取上传的文件名称
        String filename = photo.getOriginalFilename();
        //在文件名字后面加上时间戳，避免名字重复
        filename = filename.substring(0, filename.lastIndexOf("."))+"-"+new Date().getTime()+filename.substring(filename.lastIndexOf("."));
        //将图片存入服务器磁盘
        String path = request.getRealPath("tabs/image");
        try {
            photo.transferTo(new File(path+"//"+filename));
            String url = "/image/" + filename;
            banner.setUrl(url);
            bannerService.appendBanner(banner);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //更新图片状态
    @RequestMapping("/updateBanner")
    @ResponseBody
    public void updateBanner(Banner banner){
        bannerService.modifyBanner(banner);
    }
}

package com.baizhi.cmfz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/8/28.
 */
@SpringBootApplication
@MapperScan("com.baizhi.cmfz.dao")
public class CmfzApp extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(CmfzApp.class,args);
    }
}
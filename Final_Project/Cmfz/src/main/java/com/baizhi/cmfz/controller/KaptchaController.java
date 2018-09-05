package com.baizhi.cmfz.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by SK on 2018/7/30.
 */
@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletResponse response, HttpSession session) throws Exception{
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //生产验证码
        String code = defaultKaptcha.createText();
        //将验证码存入session中
        session.setAttribute("code", code);
        //获取验证码图片
        BufferedImage image = defaultKaptcha.createImage(code);
        //响应到请求页面
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //验证验证码是否正确
    @RequestMapping("/kaptchaVerify")
    public @ResponseBody  boolean  kaptchaVerify(String code, HttpSession session){
        String str = (String) session.getAttribute("code");
        if(str.equalsIgnoreCase(code)){
            return true;
        };
        return false;
    }
}

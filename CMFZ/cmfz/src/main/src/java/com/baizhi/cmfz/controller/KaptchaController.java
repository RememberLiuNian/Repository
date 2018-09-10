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

@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @RequestMapping("/setDefaultKaptcha")
    public void setDefaultKaptcha(HttpServletResponse response,HttpSession session){
        //生产验证码
        String code = defaultKaptcha.createText();
        //将验证码存入session中
        session.setAttribute("code",code);
        //获取验证码图片
        BufferedImage img = defaultKaptcha.createImage(code);
        //响应到请求界面
        try{
            ImageIO.write(img,"jpg",response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/kaptchaVerify")
    public @ResponseBody boolean kaptchaVerify(String code,HttpSession session){
        String str = (String) session.getAttribute("code");
        if (str.equalsIgnoreCase(code)){
            return true;
        }else {
            return false;
        }
    }


}

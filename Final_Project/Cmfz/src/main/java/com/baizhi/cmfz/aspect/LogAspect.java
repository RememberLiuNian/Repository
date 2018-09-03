package com.baizhi.cmfz.aspect;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by SK on 2018/8/5.
 */
@Aspect
@Configuration
public class LogAspect {
    @Autowired
    private LogService logService;

    @Pointcut(value = "@annotation(com.baizhi.cmfz.aspect.LogAnnotation)")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        //什么人、什么时间、什么事、执行结果
        //获取session中用户,什么人
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        //什么时间
        Date date = new Date();
        //获取执行的方法，什么事
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String name = annotation.name();
        //执行结果
        Object proceed = null;
        boolean flag = false;
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            flag = false;
            throwable.printStackTrace();
        }
        //入库处理
        Log log = new Log(0,admin.getName(),date,name,(flag+""));
        logService.addLog(log);

        return proceed;
    }
}

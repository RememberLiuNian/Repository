package com.baizhi.cmfz.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解的使用位置，在方法上
@Target(ElementType.METHOD)
//声明注解的生效时机，运行时生效
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    //给此注解定义一个属性，String属性类型，name属性名
    public String name();
}

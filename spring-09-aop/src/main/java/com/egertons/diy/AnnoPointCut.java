package com.egertons.diy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnoPointCut {

    @Before("execution(* com.egertons.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=====方法执行前=====(注解开发)");
    }
}

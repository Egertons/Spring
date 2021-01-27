package com.egertons.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Component
public class Log implements MethodBeforeAdvice {
    @Override
    //method：要执行的目标对象的方法
    //objects：参数
    //target：目标对象
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被调用了");
    }
}

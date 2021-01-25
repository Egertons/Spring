package com.zhanglin.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//这个注解等价于<bean id="user" class="com.zhanglin.demo.User"/>
//@Component 组件
@Component
public class User {
    @Value("zhanglin")
    public String name;
}

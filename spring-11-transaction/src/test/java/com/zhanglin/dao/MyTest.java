package com.zhanglin.dao;

import com.zhanglin.mapper.UserMapperImpl;
import com.zhanglin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void a(){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        UserMapperImpl userMapperImpl = context.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> allUser = userMapperImpl.getAllUser();
        for (User user : allUser) {
            System.out.println(user.toString());
        }
    }
}

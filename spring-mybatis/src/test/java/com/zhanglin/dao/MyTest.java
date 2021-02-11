package com.zhanglin.dao;

import com.zhanglin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void shouxieUtils() throws IOException {
        String resource = "mybatisConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void SpringMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springDao.xml");
        UserMapperImpl userMapperImpl = context.getBean("userMapperImpl", UserMapperImpl.class);
        for (User user : userMapperImpl.getAllUser()) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void UserMapperImpl2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springDao.xml");
        UserMapperImpl2 mapperImpl2 = context.getBean("UserMapperImpl2", UserMapperImpl2.class);
        List<User> allUser = mapperImpl2.getAllUser();
        for (User user : allUser) {
            System.out.println(user.toString());
        }
    }

}

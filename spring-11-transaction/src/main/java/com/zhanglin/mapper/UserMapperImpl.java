package com.zhanglin.mapper;

import com.zhanglin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getAllUser() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.addUser(new User(9, "ui", "ui"));
        //这里故意把delete的方法写错，测试事务的ACID原则；
        mapper.deleteUser(9);
        return getSqlSession().getMapper(UserMapper.class).getAllUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}

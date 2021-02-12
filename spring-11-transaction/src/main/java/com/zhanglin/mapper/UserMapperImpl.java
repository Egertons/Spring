package com.zhanglin.mapper;

import com.zhanglin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getAllUser() {
        return getSqlSession().getMapper(UserMapper.class).getAllUser();
    }
}

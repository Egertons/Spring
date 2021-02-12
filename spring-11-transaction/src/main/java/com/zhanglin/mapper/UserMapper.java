package com.zhanglin.mapper;

import com.zhanglin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> getAllUser();
    public int addUser(User user);
    public int deleteUser(@Param("id") int id);
}

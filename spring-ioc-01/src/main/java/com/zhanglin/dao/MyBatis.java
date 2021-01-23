package com.zhanglin.dao;

public class MyBatis implements UserDao{
    @Override
    public void dao() {
        System.out.println("MyBatis is running!");
    }
}

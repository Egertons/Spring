package com.zhanglin.server;

import com.zhanglin.dao.UserDao;

public class UserServer {

    public UserServer(UserDao userDao){
        this.userDao = userDao;
    }
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void run(){
        userDao.dao();
    }
}

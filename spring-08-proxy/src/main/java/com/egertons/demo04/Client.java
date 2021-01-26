package com.egertons.demo04;

import com.egertons.demo02.UserService;
import com.egertons.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationhandle proxyInvocationhandle = new ProxyInvocationhandle();
        proxyInvocationhandle.setTarget(userService);
        UserService us = (UserService) proxyInvocationhandle.proxy();
        us.add();
    }
}

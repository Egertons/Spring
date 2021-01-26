package com.egertons.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Proxy proxy = new Proxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}

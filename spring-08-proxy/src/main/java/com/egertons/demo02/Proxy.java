package com.egertons.demo02;

public class Proxy implements UserService{

    private UserServiceImpl userService;

    //Spring更推荐使用set的形式来完成
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        this.log("添加日志");
        userService.add();
    }

    @Override
    public void delete() {
        this.log("删除日志");
        userService.delete();
    }

    @Override
    public void update() {
        this.log("更新日志");
        userService.update();
    }

    @Override
    public void query() {
        this.log("查询日志");
        userService.query();
    }

    public void log(String msg){
        System.out.println("打印相关日志信息："+msg);
    }
}

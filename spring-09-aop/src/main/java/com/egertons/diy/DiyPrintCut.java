package com.egertons.diy;

import org.springframework.stereotype.Component;

@Component
public class DiyPrintCut {
    public void before(){
        System.out.println("=====before======");
    }
    public void after(){
        System.out.println("======after=======");
    }
}

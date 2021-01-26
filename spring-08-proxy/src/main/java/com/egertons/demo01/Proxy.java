package com.egertons.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public Proxy() {
    }

    @Override
    public void rent() {
        this.seeHouse();
        host.rent();
        this.hetong();
        this.pay();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你去看房");
    }

    //收中介费
    public void pay(){
        System.out.println("收中介费");
    }

    //签合同
    public void hetong(){
        System.out.println("签合同");
    }
}

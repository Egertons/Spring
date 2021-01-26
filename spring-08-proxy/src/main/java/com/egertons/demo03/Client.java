package com.egertons.demo03;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationhandle pih = new ProxyInvocationhandle();
        pih.setRent(host);
        Rent proxy = (Rent) pih.proxy();
        proxy.rent();
    }
}

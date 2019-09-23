package com.example.demo.design.factory;

public class WechaFactory implements  PayFactory{
    public PayService payRoute(){
        return new WechaPay();
    }
}

package com.example.demo.design.factory;

public class AliFactory implements PayFactory {
    public PayService payRoute() {
        return new Alipay();
    }
}

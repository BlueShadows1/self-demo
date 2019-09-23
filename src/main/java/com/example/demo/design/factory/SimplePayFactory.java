package com.example.demo.design.factory;

public class SimplePayFactory {
    public PayService payRoute(String type) {
        if ("1".equals(type)) {
            return   new Alipay();
        } else if ("2".equals(type)) {
            return new WechaPay();
        }
        return null;
    }
}

package com.example.demo.design.ab.factory;

import com.example.demo.design.factory.AliFactory;
import com.example.demo.design.factory.PayService;
import com.example.demo.design.factory.WechaFactory;

public abstract class AbstractFactory {
    public abstract  PayService payRoute();

    public PayService payRoute(String type){
        if ("1".equals(type)) {
            return new AliFactory().payRoute();
        } else if ("2".equals(type)) {
            return new WechaFactory().payRoute();
        } else {
            return payRoute();
        }
    }
}

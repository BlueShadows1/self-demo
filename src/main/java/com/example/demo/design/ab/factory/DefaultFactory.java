package com.example.demo.design.ab.factory;

import com.example.demo.design.factory.AliFactory;
import com.example.demo.design.factory.PayService;

public class DefaultFactory extends AbstractFactory {
    private AliFactory df = new AliFactory();
    public PayService payRoute() {
        return df.payRoute();
    }
}

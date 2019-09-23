package com.example.demo.design.factory;

public class MethodDemo {
    public static void main(String[] args) {
        AliFactory ali = new AliFactory();
        ali.payRoute().pay();
        new WechaFactory().payRoute().pay();
    }
}

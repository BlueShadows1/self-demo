package com.example.demo.design.factory;

public class SimpleDemo {
    public static void main(String[] args) {
        SimplePayFactory pay = new SimplePayFactory();
        pay.payRoute("1").pay();
        pay.payRoute("2").pay();
    }
}

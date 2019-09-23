package com.example.demo.design.ab.factory;

public class main {
    public static void main(String[] args) {
        DefaultFactory df = new DefaultFactory();
        df.payRoute().pay();
        df.payRoute("2").pay();
    }
}

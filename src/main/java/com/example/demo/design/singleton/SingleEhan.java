package com.example.demo.design.singleton;

public class SingleEhan {
    private static SingleEhan instance = new SingleEhan();
    private SingleEhan() {};
    public static SingleEhan getInstance() {
        return instance;
    }
}

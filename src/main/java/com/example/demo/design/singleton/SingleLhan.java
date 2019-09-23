package com.example.demo.design.singleton;

public class SingleLhan {
    private static SingleLhan instance;
    private SingleLhan() {};
    // 实现方式一：效率低
    public static synchronized SingleLhan getInstance() {
        if (instance == null) {
            instance = new SingleLhan();
        }
        return instance;
    }
    // 实现方式二，性能较高
    private static volatile SingleLhan instance2;
    //private SingleLhan1(){};
    public static SingleLhan getInstance2() {
        if (instance2 == null) {
            synchronized (SingleLhan.class) {
                if (instance2 == null) {
                    instance2 = new SingleLhan();
                }
            }
        }
        return instance2;
    }

}

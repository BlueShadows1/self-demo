package com.example.demo.design.Bulid;

public abstract  class Drink {
    public Packing pack () {
        return new Bottle();
    }
    public abstract float price();
}

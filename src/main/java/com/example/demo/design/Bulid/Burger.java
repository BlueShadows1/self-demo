package com.example.demo.design.Bulid;

public abstract  class Burger implements Item {
    public Packing pack () {
        return new Wrapper();
    }
    public abstract float price();
}

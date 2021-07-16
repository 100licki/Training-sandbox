package com.stolicki.polymorphism;

public class Holden extends Car {
    @Override
    public String startEngine() {
        return super.startEngine();
    }

    @Override
    public String accelerate() {
        return super.accelerate();
    }

    @Override
    public String brake() {
        return super.brake();
    }

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }
}

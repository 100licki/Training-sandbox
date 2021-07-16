package com.stolicki.polymorphism;

public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine() {
        return ("starting engine of " + getClass().getName());
    }

    public String accelerate() {
        return (getClass().getName() + " is accelerating...");
    }

    public String brake() {
        return (getClass().getName() + " is braking...");
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

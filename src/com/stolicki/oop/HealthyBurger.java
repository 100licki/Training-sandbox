package com.stolicki.oop;

public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private String healthyExtra2Name;
    private double healthyExtra1Price;
    private double healthyExtra2Price;


    public HealthyBurger(String meat, double price) {
        super("healthy burger", meat, price, "Brown rye roll");
    }

    public void addHealthyAddition1(String additionName, double price) {
        healthyExtra1Price = price;
        healthyExtra1Name = additionName;
    }

    public void addHealthyAddition2(String additionName, double price) {
        healthyExtra2Price = price;
        healthyExtra2Name = additionName;
    }

    @Override
    public double itemizeHamburger() {
        double totalPrice = 0;
        if(healthyExtra1Name != null) {
            System.out.println("added: " + healthyExtra1Name + ", costing: " + healthyExtra1Price + ".");
            totalPrice += healthyExtra1Price;
        }
        if(healthyExtra2Name != null) {
            System.out.println("added: " + healthyExtra2Name + ", costing: " + healthyExtra2Price + ".");
            totalPrice += healthyExtra2Price;
        }
        System.out.println("total price: " + (super.itemizeHamburger() + totalPrice));
        return (super.itemizeHamburger() + totalPrice);
    }
}
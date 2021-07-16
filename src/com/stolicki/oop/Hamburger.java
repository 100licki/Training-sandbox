package com.stolicki.oop;

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;
    private String addition1Name;
    private String addition2Name;
    private String addition3Name;
    private String addition4Name;
    private double addition1Price;
    private double addition2Price;
    private double addition3Price;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String additionName, double price) {
        addition1Price = price;
        addition1Name = additionName;

    }

    public void addHamburgerAddition2(String additionName, double price) {
        addition2Price = price;
        addition2Name = additionName;
    }

    public void addHamburgerAddition3(String additionName, double price) {
        addition3Price = price;
        addition3Name = additionName;
    }
    public void addHamburgerAddition4(String additionName, double price) {
        addition4Price = price;
        addition4Name = additionName;
    }

    public double itemizeHamburger() {
        double totalPrice = this.price;
        if(addition1Name != null) {
            System.out.println("added: " + addition1Name + ", costing: " + addition1Price + ".");
            totalPrice += addition1Price;
        }
        if(addition2Name != null) {
            System.out.println("added: " + addition2Name + ", costing: " + addition2Price + ".");
            totalPrice += addition2Price;
        }
        if(addition3Name != null) {
            System.out.println("added: " + addition3Name + ", costing: " + addition3Price + ".");
            totalPrice += addition3Price;
        }
        if(addition4Name != null) {
            System.out.println("added: " + addition4Name + ", costing: " + addition4Price + ".");
            totalPrice += addition4Price;
        }
        System.out.println("total price: " + totalPrice);
    return totalPrice;
    }
}

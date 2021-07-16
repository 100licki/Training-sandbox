package com.stolicki.oop;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("deluxe burger", "some meat", 19.10, "some roll");
        super.addHamburgerAddition1("chips", 0);
        super.addHamburgerAddition2("drink", 0);
    }

    @Override
    public void addHamburgerAddition1(String additionName, double price) {
        System.out.println("no additional items can be added to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition2(String additionName, double price) {
        System.out.println("no additional items can be added to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition3(String additionName, double price) {
        System.out.println("no additional items can be added to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition4(String additionName, double price) {
        System.out.println("no additional items can be added to a deluxe burger.");
    }
}

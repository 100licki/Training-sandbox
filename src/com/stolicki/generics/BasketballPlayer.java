package com.stolicki.generics;

public class BasketballPlayer extends Player {
    private String name;

    public BasketballPlayer(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

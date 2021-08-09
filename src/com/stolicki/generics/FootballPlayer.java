package com.stolicki.generics;

public class FootballPlayer extends Player {
    private String name;

    public FootballPlayer(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

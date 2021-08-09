package com.stolicki.generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<Player>> {
    private final String name;
    private final ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean add(T team) {
        if (!league.contains(team)) {
            league.add(team);
            return true;
        }
        return false;
    }

    public void printRanking() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}


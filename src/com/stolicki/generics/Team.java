package com.stolicki.generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private final String name;
    private int wins = 0;
    private int looses = 0;
    private int ties = 0;
    private int gamesPlayed = 0;

    private final ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public boolean addPlayer(T player) {
        if (!members.contains(player)) {
            members.add(player);
            return true;
        }
        return false;
    }

    public void printMembers() {
        for (int i = 0; i < members.size() - 1; i++) {
            System.out.println(members.get(i).getName());
        }
    }

    public void played(Team<Player> enemy, int ourPoints, int enemyPoints) {
        if(ourPoints > enemyPoints) {
            wins++;
        } else if (ourPoints == enemyPoints) {
            ties++;
        } else {
            looses++;
        }
        gamesPlayed++;
        if(enemy !=null) {
            enemy.played(null, enemyPoints,ourPoints);
        }
    }

    public String getName() {
        return name;
    }

    public int ranking() {
        return ((2 * wins) + ties);
    }

    @Override
    public int compareTo(Team<T> team) {
        return Integer.compare(team.ranking(), this.ranking());
    }
}

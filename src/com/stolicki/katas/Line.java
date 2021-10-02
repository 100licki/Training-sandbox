package com.stolicki.katas;

import java.util.Arrays;

public class Line {

    public static void main(String[] args) {
        System.out.println(Tickets(new int[]{25, 25, 25, 100, 25, 100}));
    }

    public static String Tickets(int[] peopleInLine) {
        if ((peopleInLine == null) || (peopleInLine.length == 0)) {
            return "No line";
        }
        if (!Arrays.stream(peopleInLine).allMatch(s -> s == 25 || s == 50 || s == 100)) {
            return "Wrong values";
        }
        int change = 0;
        int counterOf25 = 0;
        int counterOf50 = 0;
        int counterOf100 = 0;
        for (int value : peopleInLine) {
            switch (value) {
                case 25:
                    change += 25;
                    counterOf25++;
                    break;
                case 50:
                    if (counterOf25 > 0) {
                        counterOf25--;
                        counterOf50++;
                        change += 25;
                        break;
                    }
                    return "NO";
                case 100:
                    if ((change >= 75) && ((counterOf25 > 0 && counterOf50 > 0) || counterOf25 > 2)) {
                        counterOf100++;
                        if (counterOf50 > 0) {
                            counterOf50--;
                            counterOf25--;
                        } else {
                            counterOf25 -= 3;
                        }
                        change += 25;
                        break;
                    }
                    return "NO";
            }
        }
        return "YES";
    }
}

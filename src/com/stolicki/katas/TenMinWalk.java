package com.stolicki.katas;

public class TenMinWalk {

    public static void main(String[] args) {
        System.out.println(isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
    }

    public static boolean isValid(char[] walk) {

        int sumOfS = 0, sumOfN = 0, sumOfW = 0, sumOfE = 0;
        for (char c : walk) {
            switch (c) {
                case 's' -> sumOfS++;
                case 'n' -> sumOfN++;
                case 'w' -> sumOfW++;
                case 'e' -> sumOfE++;
            }
        }
        return ((walk.length - 1 == 10) && (sumOfE == sumOfW) && (sumOfN == sumOfS));
    }

    public static boolean isValid_v2(char[] walk) {
        String s = new String(walk);
        return s.chars().filter(p -> p == 'n').count() == s.chars().filter(p -> p == 's').count() &&
                s.chars().filter(p -> p == 'e').count() == s.chars().filter(p -> p == 'w').count() && s.chars().count() == 10;
    }
}

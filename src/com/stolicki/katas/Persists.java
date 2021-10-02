package com.stolicki.katas;

public class Persists {

    public static void main(String[] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(4));
        System.out.println(persistence(25));
        System.out.println(persistence(999));
    }

    public static int persistence(long n) {
        int counter = 0;
        while (n > 9) {
            int temp = 1;
            for (char value : Long.toString(n).toCharArray()) {
                temp *= Integer.parseInt(String.valueOf(value));
            }
            n = temp;
            counter++;
        }
        return counter;
    }
}

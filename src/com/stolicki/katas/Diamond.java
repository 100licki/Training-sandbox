package com.stolicki.katas;

public class Diamond {

    public static void main(String[] args) {
        System.out.println(print(7));
    }

    public static String print(int n) {
        if (n < 1 || n % 2 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1 - ((n / 2) + 1); i < ((n / 2) + 1); i++) {
            sb.append(" ".repeat(Math.abs(i))).append("*".repeat(((n / 2 + 1) - Math.abs(i)) * 2 - 1)).append("\n");
        }
        return sb.toString();
    }
}
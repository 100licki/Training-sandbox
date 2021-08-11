package com.stolicki.scope;

import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x) {
        System.out.println("Enter a number: ");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x < 13; x++) {
            System.out.println(x + " times " + this.x + " equals " + (x * this.x));
        }
    }

    public static void main(String[] args) {
        X x = new X(new Scanner(System.in));
        x.x();
    }
}

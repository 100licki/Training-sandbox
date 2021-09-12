package com.stolicki.lambda.challanges;

public class challenge1 {

    Runnable runnable = () -> {
        String myString = "Let's split this up into an array";
        String[] parts = myString.split(" ");
        for (String part : parts) {
            System.out.println(part);
        }
    };
}
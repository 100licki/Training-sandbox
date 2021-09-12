package com.stolicki.lambda.challanges;

import java.util.function.Function;
import java.util.function.Supplier;

public class challenge2 {


    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static void main(String[] args) {

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

//        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println(everySecondCharacter("1234567890", lambdaFunction));

        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

    public static String everySecondCharacter(String string, Function<String, String> lambdaFunction) {
        return lambdaFunction.apply(string);
    }
}

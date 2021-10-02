package com.stolicki.katas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JadenCase {
    public static void main(String[] args) {
        toJadenCase("we are, noobs. buahaha 1 123 1qawda asd  a");
        toJadenCase("");
    }


    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<String> strings = (Arrays.stream(phrase.split("\\s"))
                .collect(Collectors.toList()))
                .stream()
                .map(s -> s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1) + " ")
                .collect(Collectors.toList());

        strings.forEach(sb::append);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String toJadenCase_v2(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        return Arrays.stream(phrase.split(" "))
                .map(s -> s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining(" "));
    }
}
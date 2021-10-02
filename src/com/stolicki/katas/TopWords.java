package com.stolicki.katas;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class TopWords {

    public static void main(String[] args) {
        System.out.println(top3("?//a, b, c, d, e:e;e, f.  f   f"));
    }

    public static List<String> top3(String s) {
        Pattern pattern = Pattern.compile("^\\w");
        return (Arrays.stream(s.toLowerCase().split("[,.?!_\\-:;/\\s]"))
                .filter(pattern.asPredicate()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }
}
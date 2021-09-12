package com.stolicki.lambda.challanges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class challenge3 {
    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);

        System.out.println(topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .peek(System.out::println)
                .collect(Collectors.toList()));


    }
}

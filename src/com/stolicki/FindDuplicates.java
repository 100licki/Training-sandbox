package com.stolicki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(2);
        integers.add(1);

        System.out.println(integers);

        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates_v2(integers, 2));
        System.out.println(findDuplicates.findDuplicates_v2(emptyList, 1));
    }

    public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
        List<Integer> results = new ArrayList<>();
        if (integers.isEmpty()) {
            return Collections.emptyList();
        }
        for (int i = 0; i < integers.size(); i++) {
            int counter = 0;
            for (Integer integer : integers) {
                if (integers.get(i).equals(integer)) {
                    counter++;
                }
            }
            if (counter == numberOfDuplicates) {
                results.add(integers.get(i));
                integers.remove(i);
            }
        }
        return results;
    }

    public List<Integer> findDuplicates_v2(List<Integer> integers, int numberOfDuplicates) {
        if (integers.isEmpty()) {
            return Collections.emptyList();
        }
        return integers.stream()
                .filter(integer -> Collections.frequency(integers, integer) == numberOfDuplicates)
                .distinct()
                .collect(Collectors.toList());
    }
}
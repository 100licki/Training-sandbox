package com.stolicki.katas;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[]{5, 3}, 6));
        System.out.println(solveSuperMarketQueue(new int[]{2, 5, 2, 2, 3, 4, 4, 7, 3, 2, 1, 2}, 4));
        System.out.println(solveSuperMarketQueue(new int[]{5, 6, 5, 6, 4, 6, 4, 4, 6, 6, 1}, 3));
        System.out.println(solveSuperMarketQueue(new int[]{5, 2, 5, 7, 5, 2, 3}, 5));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0) {
            return 0;
        }
        List<Integer> queue = Arrays.stream(customers).boxed().collect(Collectors.toList());
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            counter.put(i, 0);
        }
        for (Integer value : queue) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int i = 0; i < n; i++) {
                    int temp = counter.get(i);
                    if (temp < min) {
                        min = temp;
                        minIndex = i;
                    }
                }
                if (j == minIndex) {
                    counter.replace(j, counter.get(j) + value);
                    break;
                }
            }
        }
        return Collections.max(new ArrayList<>(counter.values()));
    }
}
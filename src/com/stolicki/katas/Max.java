package com.stolicki.katas;

import java.util.Arrays;

public class Max {

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{}));
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    public static int sequence(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sequence = Arrays.stream(arr).skip(i).limit(j - i + 1).sum();
                if (sequence > max) {
                    max = sequence;
                }
            }
        }
        return max;
    }
}

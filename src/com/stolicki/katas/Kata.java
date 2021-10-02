package com.stolicki.katas;

import java.util.Arrays;

public class Kata {

    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[]{0}));
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
        System.out.println(findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));
        System.out.println(findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        System.out.println(findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }

    public static int findEvenIndex(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int leftSum = Arrays.stream(arr).limit(i).sum();
            int rightSum = Arrays.stream(arr).skip(i + 1).sum();

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}

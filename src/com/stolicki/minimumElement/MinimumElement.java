package com.stolicki.minimumElement;

import java.util.Scanner;

public class MinimumElement {

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[] readElements(int value) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[value];
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        int minValue = array[0];
        for (int i = 1; i <= array.length - 1; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
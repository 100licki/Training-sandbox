package com.stolicki.sortedArray;

import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {
        int[] eh = {1,2,3,4,5};
        sortIntegers(eh);
    }

    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        for (int x = array.length-1; x >= 1; x--) {
            for (int i = 0; i < x; i++) {
                if (array[i] < array[i + 1]) {
                    int placeholder;
                    placeholder = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = placeholder;
                }
            }
        }
        return array;
    }
}
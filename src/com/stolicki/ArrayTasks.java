package com.stolicki;

import java.util.Arrays;

public class ArrayTasks {
    public static void main(String[] args) {

        //swap first and last number in array


//        int[] numbers = new int[2];
//        numbers[0] = 6;
//        numbers[1] = 9;

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int i = numbers[0];
        numbers[0] = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = i;


        System.out.println(Arrays.toString(numbers));
//
//        for(int i=0; i< numbers.length; i++) {
//            int number = numbers[i];
//            System.out.println(number);
//        }
//
//        for (int number : numbers) {
//            System.out.println(number);
//        }
//
    }
}
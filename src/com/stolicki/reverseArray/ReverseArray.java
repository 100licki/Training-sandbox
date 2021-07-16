package com.stolicki.reverseArray;

import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        int tempValue;
        int counter = array.length-1;
        for (int i = 0; i <= array.length/2; i++) {
            tempValue = array[counter];
            array[counter] = array[i];
            array[i] = tempValue;
            counter--;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}

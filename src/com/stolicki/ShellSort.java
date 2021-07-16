package com.stolicki;

public class ShellSort {
    private int[] theArray;
    private int arraySize;

    public void sort() {
        int inner, outer, temp;
        int interval = 1;
        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;
            while (interval > 0) {
                for (outer = interval; outer < arraySize; outer++) {
                    temp = theArray[outer];
                    System.out.println("Copy " + theArray[outer] + " into temp");
                    inner = outer;
                    System.out.println("Checking if " + theArray[inner - interval]
                            + " in index " + (inner - interval) + " is bigger than " + temp);
                    while (inner > interval - 1 && theArray[inner - interval] >= temp) {
                        System.out.println("In while checking if " + theArray[inner - interval]
                                + " in index " + (inner - interval) + " is bigger than " + temp);
                        theArray[inner] = theArray[inner - interval];
                        System.out.println(theArray[inner - interval] + " moved to index " + inner);
                        inner -= interval;
                        System.out.println("inner = " + inner);
                    }
                }

            }
        }
    }
}

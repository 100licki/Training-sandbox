package com.stolicki.series;

public class Series {

    public static long nSun(int n) {
        if (n < 0) {
            return -1;
        }
        int counter = n;
        long sum = 0;
        while (counter != 0) {
            sum += counter;
            counter--;
        }
        return sum;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return -1;
        }
        int counter = n;
        long factorial = 1;
        while (counter != 1) {
            factorial *= counter;
            counter--;
        }
        return factorial;
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else {
            long nMin1 = 1;
            long nMin2 = 0;
            long fib = 0;
            for (int i = 1; i < n; i++) {
                fib = (nMin2 + nMin1);
                nMin2 = nMin1;
                nMin1 = fib;
            }
            return fib;
        }
    }
}

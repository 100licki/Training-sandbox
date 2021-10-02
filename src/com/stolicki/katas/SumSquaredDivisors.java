package com.stolicki.katas;

import java.util.*;
import java.util.stream.LongStream;

public class SumSquaredDivisors {
    public static String listSquared(long m, long n) {
        Map<Long, Long> results = new LinkedHashMap<>();
        if (m == 1 || n == 1) {
            results.put(1L, 1L);
        }
        for (long i = m; i <= n; i++) {
            long sumOfSquares = 0;
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    long squaredValue = j * j;
                    sumOfSquares += squaredValue;
                }
            }
            double squareRoot = Math.sqrt(sumOfSquares);
            long test = (long) (squareRoot + 0.5);
            if (test * test == sumOfSquares) {
                results.put(i, sumOfSquares);
            }
        }
        if (!results.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            results.forEach((k, v) -> sb.append("[" + k + ", " + v + "], "));
            sb.setLength(sb.length() - 2);
            sb.append("]");
            return sb.toString();
        } else {
            return "[]";
        }
    }

    public static String listSquared_v2(long m, long n) {
        ArrayList<String> strings = new ArrayList<>();
        LongStream.rangeClosed(m, n).forEach(current -> {
            long sum = LongStream.rangeClosed(1, current).filter(i -> current % i == 0).map(i -> i * i).sum();
            if (Math.sqrt(sum) % 1 == 0) strings.add(String.format("[%d, %d]", current, sum));
        });
        return String.valueOf(strings);
    }
}
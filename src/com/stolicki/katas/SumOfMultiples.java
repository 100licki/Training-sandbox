package com.stolicki.katas;

import java.util.stream.IntStream;

public class SumOfMultiples {

    public int sumOfMultiples(int number) {
        if (number <= 0) {
            return 0;
        }
        return IntStream.range(0, number)
                .filter(integer -> (integer % 3 == 0) || (integer % 5 == 0))
                .sum();
    }
}

package code.wars.count_divisors;

import java.util.stream.IntStream;

public class FindDivisor {

    public long numberOfDivisors(int n) {

        return IntStream.range(1, n)
                .filter(value -> n % value == 0)
                .count() + 1;
    }
}

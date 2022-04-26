package code.wars.sum_of_numbers;

import java.util.stream.IntStream;

public class Sum {

    public int getSum(int a, int b) {

        if (a == b) {
            return a;
        } else {
            final int start = Math.min(a, b);
            final int end = Math.max(a, b);
            return IntStream.rangeClosed(start, end)
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
    }
}

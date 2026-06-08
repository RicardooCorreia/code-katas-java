package code.wars.sum_of_minimums;

import static java.util.Arrays.stream;

public class Kata {

    public static int sumOfMinimums(int[][] arr) {

        return stream(arr)
            .mapToInt(ints -> stream(ints).min().orElse(0))
            .sum();
    }
}

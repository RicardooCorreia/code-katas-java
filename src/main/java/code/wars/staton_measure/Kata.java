package code.wars.staton_measure;

import java.util.Arrays;

public class Kata {

    public static int stantonMeasure(int[] arr) {

        final long oneCount = countNumber(arr, 1);
        return (int) countNumber(arr, oneCount);
    }

    private static long countNumber(int[] arr, long toCount) {
        return Arrays.stream(arr)
                .filter(i -> i == toCount)
                .count();
    }
}

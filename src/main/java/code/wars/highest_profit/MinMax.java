package code.wars.highest_profit;

import java.util.Arrays;

public class MinMax {

    public static int[] minMax(int[] arr) {

        final int[] sortedArray = Arrays.stream(arr)
                .sorted()
                .toArray();

        return new int[]{sortedArray[0], sortedArray[arr.length - 1]};
    }
}

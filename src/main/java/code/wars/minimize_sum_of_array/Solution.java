package code.wars.minimize_sum_of_array;

import java.util.Arrays;

public class Solution {

    public static int minSum(int[] passed) {

        Arrays.sort(passed);

        final int length = passed.length;
        int sum = 0;
        for (int i = 0; i < length / 2; i++) {
            sum+= passed[i] * passed[length - i - 1];
        }
        return sum;
    }
}

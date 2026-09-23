package code.wars.largest_pari_sum_in_array;

public class Solution {

    public static int largestPairSum(int[] numbers) {

        if (numbers.length < 2) return 0;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (var number : numbers) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2) {
                max2 = number;
            }
        }

        return max1 + max2;
    }
}

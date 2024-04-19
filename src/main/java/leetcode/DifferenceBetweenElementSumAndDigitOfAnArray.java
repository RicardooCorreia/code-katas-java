package leetcode;

import java.util.Arrays;

public class DifferenceBetweenElementSumAndDigitOfAnArray {

    static class Solution {
        public int differenceOfSum(int[] nums) {


            int totalSum = Arrays.stream(nums).sum();
            int digitSum = Arrays.stream(nums)
                    .flatMap(value -> String.valueOf(value)
                            .chars()
                            .map(i -> i - 48))
                    .sum();

            return Math.abs(totalSum - digitSum);
        }
    }
}

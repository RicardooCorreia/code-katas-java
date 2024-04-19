package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 * <p>
 * Example 1:
 *      Input: nums = [18,43,36,13,7]
 *      Output: 54
 *      Explanation: The pairs (i, j) that satisfy the conditions are:
 *          - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
 *          - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
 *      So the maximum sum that we can obtain is 54.
 * Example 2:
 *      Input: nums = [10,12,19,14]
 *      Output: -1
 *      Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 * <p>
 * Constraints:
 *      1 <= nums.length <= 105
 *      1 <= nums[i] <= 109
 */
public class MaxSumOfPairWithEqualSumOfDigits {

    static class Solution {
        public int maximumSum(int[] nums) {

            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(this::sumOfDigits, Collectors.toList()))
                    .values()
                    .stream()
                    .filter(list -> list.size() > 1)
                    .mapToInt(this::getMaxPossibleSumOfTwoNumbers)
                    .max()
                    .orElse(-1);
        }

        private int getMaxPossibleSumOfTwoNumbers(List<Integer> values) {

            int maxNumber = Integer.MIN_VALUE, secondMaxNumber = Integer.MIN_VALUE;
            for (Integer value : values) {
                if (maxNumber < value) {
                    secondMaxNumber = maxNumber;
                    maxNumber = value;
                } else if (secondMaxNumber < value) {
                    secondMaxNumber = value;
                }
            }
            return maxNumber + secondMaxNumber;
        }

        private Integer sumOfDigits(Integer integer) {

            return String.valueOf(integer)
                    .chars()
                    .map(operand -> operand - 48)
                    .sum();
        }
    }
}

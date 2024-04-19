package leetcode;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes {

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {

            int max = Integer.MIN_VALUE;
            int current = 0;
            for (int num : nums) {
                if (num == 1) {
                    current++;
                    if (current > max) {
                        max = current;
                    }
                } else {
                    current = 0;
                }
            }

            return Math.max(max, 0);
        }
    }
}

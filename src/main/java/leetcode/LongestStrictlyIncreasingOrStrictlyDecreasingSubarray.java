package leetcode;

/*
You are given an array of integers nums. Return the length of the longest
subarray of nums which is either strictly increasing or strictly decreasing.

Example 1:
    Input: nums = [1,4,3,3,2]
    Output: 2
    Explanation:
        The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
        The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
        Hence, we return 2.

Example 2:
    Input: nums = [3,3,3,3]
    Output: 1
    Explanation:
        The strictly increasing subarrays of nums are [3], [3], [3], and [3].
        The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
        Hence, we return 1.

Example 3:
    Input: nums = [3,2,1]
    Output: 3
    Explanation:
        The strictly increasing subarrays of nums are [3], [2], and [1].
        The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].
        Hence, we return 3.

Constraints:
    1 <= nums.length <= 50
    1 <= nums[i] <= 50
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    static class Solution {
        public int longestMonotonicSubarray(int[] nums) {

            if (nums.length < 2) {
                return nums.length;
            }

            int max = 1, currentCount = 1;
            int previousNum = nums[0];
            Boolean increasing = null;

            for (int i = 1; i < nums.length; i++) {
                int currentNum = nums[i];
                if (increasing == null) increasing = currentNum > previousNum;
                if (breaksIncreasing(increasing, currentNum, previousNum) || breaksDecreasing(increasing, currentNum, previousNum)) {
                    max = Math.max(max, currentCount);
                    if (previousNum == currentNum) {
                        currentCount = 0;
                    } else if (previousNum > currentNum) {
                        increasing = false;
                        currentCount = 1;
                    } else {
                        increasing = true;
                        currentCount = 1;
                    }
                }
                previousNum = currentNum;
                currentCount++;
            }
            return Math.max(max, currentCount);
        }

        private static boolean breaksDecreasing(boolean increasing, int currentNum, int previous) {
            return !increasing && currentNum >= previous;
        }

        private static boolean breaksIncreasing(boolean increasing, int currentNum, int previous) {
            return increasing && currentNum <= previous;
        }
    }
}

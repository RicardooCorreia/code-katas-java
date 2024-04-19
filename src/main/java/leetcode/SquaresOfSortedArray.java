package leetcode;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 *      Input: nums = [-4,-1,0,3,10]
 *      Output: [0,1,9,16,100]
 *      Explanation: After squaring, the array becomes [16,1,0,9,100].
 *      After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *      Input: nums = [-7,-3,2,3,11]
 *      Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 *      1 <= nums.length <= 104
 *      -104 <= nums[i] <= 104
 *      nums is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    static class Solution {
        public int[] sortedSquares(int[] nums) {

            LinkedList<Integer> negatives = new LinkedList<>();
            LinkedList<Integer> positives = new LinkedList<>();
            for (int num : nums) {
                int squaredNumber = (int) Math.pow(num, 2);
                if (num > 0) {
                    positives.add(squaredNumber);
                } else {
                    negatives.add(squaredNumber);
                }
            }

            return getSortedResult(nums, negatives, positives);
        }

        private static int[] getSortedResult(int[] nums, LinkedList<Integer> negatives, LinkedList<Integer> positives) {
            int[] result = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                Integer negative = Optional.ofNullable(negatives.peekFirst()).orElse(-1);
                Integer positive = Optional.ofNullable(positives.peekLast()).orElse(-1);
                if (negative > positive) {
                    result[i] = negative;
                    negatives.removeFirst();
                } else {
                    result[i] = positive;
                    positives.removeLast();
                }
            }
            return result;
        }
    }
}

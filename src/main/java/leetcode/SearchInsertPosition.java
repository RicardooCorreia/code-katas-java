package leetcode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 *      Input: nums = [1,3,5,6], target = 5
 *      Output: 2
 * Example 2:
 *      Input: nums = [1,3,5,6], target = 2
 *      Output: 1
 * Example 3:
 *      Input: nums = [1,3,5,6], target = 7
 *      Output: 4
 * <p>
 * Constraints:
 *      1 <= nums.length <= 104
 *      -104 <= nums[i] <= 104
 *      nums contains distinct values sorted in ascending order.
 *      -104 <= target <= 104
 */
public class SearchInsertPosition {

    static class Solution {
        public int searchInsert(int[] nums, int target) {

            return searchInsert(0, nums.length, nums, target);
        }

        private int searchInsert(int from, int to, int[] nums, int target) {

            int middleIndex = (from + to) / 2;
            int numInTheMiddle = nums[middleIndex];
            if (to - from <= 1) {
                return numInTheMiddle < target ? to : from;
            }

            if (numInTheMiddle == target) {
                return middleIndex;
            } else if (numInTheMiddle < target) {
                return searchInsert(middleIndex, to, nums, target);
            } else {
                return searchInsert(from, middleIndex, nums, target);
            }
        }
    }
}

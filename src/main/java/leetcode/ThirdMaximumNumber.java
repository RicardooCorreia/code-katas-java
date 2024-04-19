package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 * <p>
 * Example 1:
 *      Input: nums = [3,2,1]
 *      Output: 1
 *      Explanation:
 *          The first distinct maximum is 3.
 *          The second distinct maximum is 2.
 *          The third distinct maximum is 1.
 * Example 2:
 *      Input: nums = [1,2]
 *      Output: 2
 *      Explanation:
 *          The first distinct maximum is 2.
 *          The second distinct maximum is 1.
 *          The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *      Input: nums = [2,2,3,1]
 *      Output: 1
 *      Explanation:
 *          The first distinct maximum is 3.
 *          The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 *          The third distinct maximum is 1.
 * Constraints:
 *      1 <= nums.length <= 104
 *      -231 <= nums[i] <= 231 - 1
 */
public class ThirdMaximumNumber {

    static class Solution {
        public int thirdMax(int[] nums) {

            Integer firstMax = null, secondMax = null, thirdMax = null;
            Set<Integer> seenNumbers = new HashSet<Integer>();
            for (int num : nums) {
                if (seenNumbers.contains(num)) {
                    continue;
                }
                seenNumbers.add(num);
                if (firstMax == null || num > firstMax) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = num;
                } else if (secondMax == null || num > secondMax) {
                    thirdMax = secondMax;
                    secondMax = num;
                } else if (thirdMax == null || num > thirdMax) {
                    thirdMax = num;
                }
            }

            return thirdMax == null ? firstMax : thirdMax;
        }
    }
}
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Example 1:
 *      Input: nums = [1,3,4,2,2]
 *      Output: 2
 * Example 2:
 *      Input: nums = [3,1,3,4,2]
 *      Output: 3
 * Example 3:
 *      Input: nums = [3,3,3,3,3]
 *      Output: 3
 * <p>
 * Constraints:
 *      1 <= n <= 105
 *      nums.length == n + 1
 *      1 <= nums[i] <= n
 *      All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * Follow up:
 *      How can we prove that at least one duplicate number must exist in nums?
 *      Can you solve the problem in linear runtime complexity?
 */
public class FindTheDuplicateNumber {

    static class Solution {
        public int findDuplicate(int[] nums) { // O(n) runtime O(1) space - Slow
            int slow = 0;
            int fast = 1;
            while (nums[slow] != nums[fast]) {
                slow = (slow + 1) % nums.length;
                fast = (fast + 2) % nums.length;
                if (slow == fast) {
                    fast = (fast + 1) % nums.length;
                }
            }
            return nums[slow];
        }

        public int findDuplicateHigherTimeComplexity(int[] nums) { // O(n^2) runtime O(1) space

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == nums[i]) return nums[i];
                }
            }
            return -1;
        }

        public int findDuplicateLowerTimeComplexity(int[] nums) { // O(n) runtime O(n) space

            Set<Integer> seenNumbers = new HashSet<Integer>();
            for (int num : nums) {
                if (seenNumbers.contains(num)) {
                    return num;
                } else {
                    seenNumbers.add(num);
                }

            }
            return -1;
        }
    }
}


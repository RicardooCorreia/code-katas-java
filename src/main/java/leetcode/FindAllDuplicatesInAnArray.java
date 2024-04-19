package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
 *  appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * <p>
 *  Example 1:
 *      Input: nums = [4,3,2,7,8,2,3,1]
 *      Output: [2,3]
 * Example 2:
 *      Input: nums = [1,1,2]
 *      Output: [1]
 * Example 3:
 *      Input: nums = [1]
 *      Output: []
 * <p>
 *  Constraints:
 *      n == nums.length
 *      1 <= n <= 105
 *      1 <= nums[i] <= n
 *      Each element in nums appears once or twice.
 */
public class FindAllDuplicatesInAnArray {

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            Set<Integer> seenNumbers = new HashSet<>();
            List<Integer> duplicates = new LinkedList<>();

            for (int num : nums) {
                if (seenNumbers.contains(num)) {
                    duplicates.add(num);
                } else {
                    seenNumbers.add(num);
                }
            }
            return duplicates;
        }
    }
}

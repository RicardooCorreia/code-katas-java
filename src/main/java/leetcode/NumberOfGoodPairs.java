package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:
    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:
    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.
Example 3:
    Input: nums = [1,2,3]
    Output: 0

Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */
public class NumberOfGoodPairs {

    static class Solution {
        public int numIdenticalPairs(int[] nums) {

            Map<Integer, Integer> numberIndexes = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                numberIndexes.putIfAbsent(num, 0);
                numberIndexes.put(num, numberIndexes.get(num) + 1);
            }

            int result = 0;
            for (Integer number : numberIndexes.keySet()) {
                Integer nIndexes = numberIndexes.get(number);
                result += 0.5 * (nIndexes - 1) * nIndexes;
            }

            return result;
        }
    }
}

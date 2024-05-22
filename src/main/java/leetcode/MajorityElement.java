package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
    Input: nums = [3,2,3]
    Output: 3
Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    static class Solution {
        public int majorityElement(int[] nums) {

            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElseThrow();
        }
    }
}

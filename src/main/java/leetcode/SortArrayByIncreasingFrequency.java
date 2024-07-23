package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
    Input: nums = [1,1,2,2,2,3]
    Output: [3,1,1,2,2,2]
    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:
    Input: nums = [2,3,1,3,2]
    Output: [1,3,3,2,2]
    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:
    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
    Output: [5,-1,4,4,-6,-6,1,1,1]

Constraints:
    1 <= nums.length <= 100
    -100 <= nums[i] <= 100
 */
public class SortArrayByIncreasingFrequency {

    static class Solution {
        public int[] frequencySort(int[] nums) {

            Comparator<Map.Entry<Integer, Long>> frequencyComparator =
                    (entry1, entry2) -> {
                        int frequencyResult = Math.toIntExact(entry1.getValue() - entry2.getValue());
                        return frequencyResult == 0 ? entry2.getKey() - entry1.getKey() : frequencyResult;
                    };
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(frequencyComparator)
                    .flatMapToInt(entry ->
                            IntStream.generate(entry::getKey)
                                    .limit(entry.getValue()))
                    .toArray();
        }
    }
}

package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.
Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.

Constraints:
    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105
 */
public class ThreeSum {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length;
            int index = 0;
            List<List<Integer>> arr = new ArrayList<>();
            while (index < length - 2) {
                if (index > 0 && nums[index] == nums[index - 1]) {
                    index++;
                    continue;
                }
                int j = index + 1;
                int k = length - 1;
                while (j < k) {
                    int total = nums[index] + nums[j] + nums[k];
                    if (total > 0) {
                        k--;
                    } else if (total < 0) {
                        j++;
                    } else {
                        arr.add(Arrays.asList(nums[index], nums[j], nums[k]));
                        do {
                            j++;
                        } while (nums[j] == nums[j - 1] && j < k);
                    }
                }
                if (nums[index] > 0) return arr;
                index++;
            }
            return arr;
        }
    }

    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {

            Set<List<Integer>> result = new HashSet<>();

            Map<Integer, Long> numCount = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

            for (int i = 0; i < nums.length; i++) {
                int first = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int second = nums[j];
                    int missingNumber = (first + second) * -1;
                    if (numCount.containsKey(missingNumber)) {
                        Long count = numCount.get(missingNumber);
                        if (missingNumber == first) {
                            count--;
                        }
                        if (missingNumber == second) {
                            count--;
                        }
                        if (count > 0) {
                            result.add(Stream.of(first, second, missingNumber).sorted().toList());
                        }
                    }
                }
            }
            return new LinkedList<>(result);
        }
    }
}

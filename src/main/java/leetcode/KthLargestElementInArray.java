package leetcode;

import java.util.Arrays;

public class KthLargestElementInArray {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {

            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}

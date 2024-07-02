package leetcode;

public class NeitherMinimumNorMaximum {

    static class Solution {
        public int findNonMinOrMax(int[] nums) {

            if (nums == null || nums.length <= 2) {
                return -1;
            }

            int min = Math.min(nums[0], nums[1]);
            int max = Math.max(nums[0], nums[1]);
            int possibleSolution = -1;

            for (int i = 2; i < nums.length; i++) {
                int num = nums[i];
                if (num < min) {
                    possibleSolution = min;
                    min = num;
                } else if (num > max) {
                    possibleSolution = max;
                    max = num;
                } else {
                    possibleSolution = num;
                }
            }

            return possibleSolution;
        }
    }
}

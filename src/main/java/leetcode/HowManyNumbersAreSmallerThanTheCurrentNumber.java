package leetcode;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {

            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) continue;
                    else if (nums[i] > nums[j]) {
                        result[i]++;
                    }
                }
            }

            return result;
        }
    }
}

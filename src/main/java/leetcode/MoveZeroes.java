package leetcode;

import java.util.Arrays;

public class MoveZeroes {

    static class Solution {
        public void moveZeroes(int[] nums) {

            int[] nonZeros = Arrays.stream(nums)
                    .filter(value -> value != 0)
                    .toArray();

            System.arraycopy(nonZeros, 0, nums, 0, nonZeros.length);
            Arrays.fill(nums, nonZeros.length, nums.length, 0);
        }
    }
}

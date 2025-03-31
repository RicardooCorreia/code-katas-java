package leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            int[] copy = new int[nums.length];

            for (int num : nums) {
                copy[num - 1]++;
            }

            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] == 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }
}

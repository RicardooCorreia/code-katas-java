package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {

    static class Solution {
        public String largestNumber(int[] nums) {

            String result = Arrays.stream(nums)
                    .boxed()
                    .sorted(Solution::compare)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            if (result.startsWith("0")) {
                return "0";
            } else {
                return result;
            }
        }

        private static int compare(Integer o1, Integer o2) {
            return (String.valueOf(o2) + o1).compareTo(String.valueOf(o1) + o2);
        }
    }
}

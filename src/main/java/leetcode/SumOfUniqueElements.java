package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SumOfUniqueElements {

    static class Solution {
        public int sumOfUnique(int[] nums) {

            Map<Integer, Long> numberCount = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

            return numberCount.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .mapToInt(Map.Entry::getKey)
                    .sum();
        }
    }
}

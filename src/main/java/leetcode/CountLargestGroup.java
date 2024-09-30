package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountLargestGroup {

    static class Solution {
        public int countLargestGroup(int n) {

            Collection<Long> groupCount = IntStream.range(1, n + 1)
                    .map(this::sumOfDigits)
                    .boxed()
                    .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()))
                    .values();

            int maxValue = Integer.MIN_VALUE;
            int maxCount = 0;
            for (Long count : groupCount) {
                if (count > maxValue) {
                    maxValue = Math.toIntExact(count);
                    maxCount = 1;
                } else if (count == maxValue) {
                    maxCount++;
                }
            }
            return maxCount;
        }

        private int sumOfDigits(int i) {

            String[] split = String.valueOf(i).split("");
            return Arrays.stream(split)
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
    }
}

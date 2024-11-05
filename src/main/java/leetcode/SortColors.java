package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SortColors {

    static class Solution {
        public void sortColors(int[] nums) {

            int count0 = 0, count1 = 0, count2 = 0;
            for (int num : nums) {
                switch (num) {
                    case 0:
                        count0++;
                        break;
                    case 1:
                        count1++;
                        break;
                    case 2:
                        count2++;
                        break;
                }
            }

            populateArray(nums, 0, count0, 0);
            populateArray(nums, count0, count0 + count1, 1);
            populateArray(nums, count0 + count1, count0 + count1 + count2, 2);
        }

        private static void populateArray(int[] nums, int lowerLimit, int upperLimit, int value) {
            IntStream.range(lowerLimit, upperLimit)
                    .forEach(i -> nums[i] = value);
        }
    }

    static class Solution2 {
        public void sortColors(int[] nums) {


            Map<Integer, Integer> numCount = new HashMap<>();

            for (int num : nums) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            int lowerLimit = 0, upperLimit;
            for (Map.Entry<Integer, Integer> entry : orderedEntries(numCount)) {
                Integer count = entry.getValue();
                upperLimit = count + lowerLimit;
                populateArray(nums, lowerLimit, upperLimit, entry.getKey());
                lowerLimit = upperLimit;
            }
        }

        private static void populateArray(int[] nums, int lowerLimit, int upperLimit, int value) {
            IntStream.range(lowerLimit, upperLimit)
                    .forEach(i -> nums[i] = value);
        }

        private static List<Map.Entry<Integer, Integer>> orderedEntries(Map<Integer, Integer> numCount) {
            return numCount.entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getKey))
                    .toList();
        }
    }
}

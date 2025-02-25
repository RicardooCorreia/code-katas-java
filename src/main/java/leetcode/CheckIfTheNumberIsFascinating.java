package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckIfTheNumberIsFascinating {

    static class Solution {
        public boolean isFascinating(int n) {

            Set<String> numberToContains = Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
            String concatenatedNumber = n + String.valueOf(n * 2) + n * 3;

            Map<String, Long> numberList = Arrays.stream(concatenatedNumber.split(""))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            boolean hasMoreThanOneOccurrence = numberList.values().stream()
                    .anyMatch(aLong -> aLong > 1);

            if (hasMoreThanOneOccurrence) {
                return false;
            }

            return numberList.keySet().containsAll(numberToContains) && !numberList.containsKey("0");
        }
    }
}

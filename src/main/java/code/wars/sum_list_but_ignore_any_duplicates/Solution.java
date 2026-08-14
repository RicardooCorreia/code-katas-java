package code.wars.sum_list_but_ignore_any_duplicates;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public static int sumNoDuplicates(int[] arr) {

        return stream(arr)
            .boxed()
            .collect(groupingBy(integer -> integer, counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .sum();
    }
}


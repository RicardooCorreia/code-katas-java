package code.wars.simple_frequency_sort;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public static int[] sortByFrequency(int[] array) {

        final var elementFrequency = stream(array)
            .boxed()
            .collect(groupingBy(o -> o, counting()));

        return stream(array)
            .boxed()
            .sorted((num1, num2) -> {
                final var compare = elementFrequency.get(num2).compareTo(elementFrequency.get(num1));
                if (compare == 0) {
                    return num1.compareTo(num2);
                }
                return compare;
            })
            .mapToInt(integer -> integer)
            .toArray();
    }
}

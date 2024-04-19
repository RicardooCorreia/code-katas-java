package code.wars.count_most_frequent_item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Kata {

    public static int mostFrequentItemCount(int[] collection) {

        if (collection.length == 0) {
            return 0;
        }

        return Math.toIntExact(Arrays.stream(collection)
                                       .boxed()
                                       .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                                       .entrySet()
                                       .stream()
                                       .max(Comparator.comparingLong(Map.Entry::getValue))
                                       .map(Map.Entry::getValue)
                                       .orElseThrow());
    }
}

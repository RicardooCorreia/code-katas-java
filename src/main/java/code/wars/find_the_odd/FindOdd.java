package code.wars.find_the_odd;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindOdd {

    public static int findIt(int[] a) {

        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .findAny()
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}

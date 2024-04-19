package code.wars.pair_of_gloves;

import java.util.Arrays;
import java.util.stream.Collectors;

class Kata {

    public static int numberOfPairs(String[] gloves) {

        return Arrays.stream(gloves)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .values()
                .stream()
                .mapToInt(value -> (int) (value / 2))
                .sum();
    }
}

package code.wars.weight_for_weight;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WeightSort {

    public static String orderWeight(String original) {

        return Arrays.stream(original.split(" "))
                .sorted((o1, o2) -> {
                    final int result = compute(o1) - compute(o2);
                    if (result == 0) {
                        return o1.compareTo(o2);
                    }
                    return result;
                })
                .collect(Collectors.joining(" "));
    }

    private static int compute(String original) {
        return original.chars()
                .map(c -> c - 48)
                .sum();
    }
}

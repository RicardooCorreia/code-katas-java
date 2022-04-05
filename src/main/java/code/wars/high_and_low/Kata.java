package code.wars.high_and_low;

import java.util.Arrays;
import java.util.Map;

public class Kata {
    public static String highAndLow(String numbers) {

        final Map.Entry<Integer, Integer> maxAndMin = Map.entry(Integer.MIN_VALUE, Integer.MAX_VALUE);
        final Map.Entry<Integer, Integer> result =
                Arrays.stream(numbers.split(" "))
                        .map(Integer::valueOf)
                        .reduce(maxAndMin,
                                (tuple, integer) ->
                                        Map.entry(Math.max(tuple.getKey(), integer), Math.min(tuple.getValue(), integer)),
                                (tuple1, tuple2) -> tuple1);
        return String.join(" ", result.getKey().toString(), result.getValue().toString());
    }
}

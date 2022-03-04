package code.wars.array_diff;

import java.util.Arrays;
import java.util.List;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {

        final List<Integer> toExclude = Arrays.stream(b).boxed().toList();
        return Arrays.stream(a)
                .filter(value -> !toExclude.contains(value))
                .toArray();
    }
}

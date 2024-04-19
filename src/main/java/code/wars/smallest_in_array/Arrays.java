package code.wars.smallest_in_array;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Arrays {

    public static int findSmallest(final int[] numbers, final String toReturn) {

        final Integer index = IntStream.range(0, numbers.length)
                .boxed()
                .min(Comparator.comparingInt(o -> numbers[o]))
                .orElse(0);

        return "index".equals(toReturn) ? index : numbers[index];
    }
}

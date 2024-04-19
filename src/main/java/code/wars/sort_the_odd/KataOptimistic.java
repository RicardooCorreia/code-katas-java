package code.wars.sort_the_odd;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class KataOptimistic {

    public static int[] sortArray(final int[] array) {

        final PrimitiveIterator.OfInt sortedOdds = IntStream.of(array)
                .filter(value -> value % 2 != 0)
                .sorted()
                .iterator();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = sortedOdds.nextInt();
            }
        }

        return array;
    }
}

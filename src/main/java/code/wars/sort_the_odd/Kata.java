package code.wars.sort_the_odd;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * To make this exercise more challenging, it's assumed that the filtering (number % 2) is an expensive operation.
 * This way, we can only filter the array once.
 *
 * The optimistic version is in {@link KataOptimistic}
 */
public class Kata {

    public static int[] sortArray(int[] array) {

        final List<Pair<Integer, Integer>> sortedOddsWithOriginalPositions = IntStream.range(0, array.length)
                .mapToObj(i -> new Pair<>(i, array[i]))
                .filter(pair -> pair.value % 2 != 0)
                .sorted(Comparator.comparingInt(pair -> pair.value))
                .toList();

        final List<Integer> sortedKeys = sortedOddsWithOriginalPositions.stream()
                .map(pair -> pair.key)
                .sorted(Comparator.comparingInt(o -> o))
                .toList();

        for (int i = 0; i < sortedKeys.size(); i++) {
            array[sortedKeys.get(i)] = sortedOddsWithOriginalPositions.get(i).value;
        }

        return array;
    }

    private record Pair<K, V>(K key, V value) {
    }
}

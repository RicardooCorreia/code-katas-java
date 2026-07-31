package code.wars.sort_by_last_char;

import java.util.Map;

import static java.util.Map.entry;
import static java.util.stream.IntStream.range;

public class Kata {

    public static String[] last(String x) {

        final var words = x.split(" ");
        return range(0, words.length)
            .mapToObj(i -> entry(i, words[i]))
            .sorted((entry1, entry2) -> {
                final var lastChar1 = getLastChar(entry1.getValue());
                final var lastChar2 = getLastChar(entry2.getValue());
                final var lastCharCompare = lastChar1 - lastChar2;
                if (lastCharCompare == 0) {
                    return entry1.getKey() - entry2.getKey();
                } else {
                    return lastCharCompare;
                }
            })
            .map(Map.Entry::getValue)
            .toArray(String[]::new);
    }

    private static char getLastChar(String word) {
        return word.charAt(word.length() - 1);
    }
}

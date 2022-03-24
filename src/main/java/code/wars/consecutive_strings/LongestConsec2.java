package code.wars.consecutive_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LongestConsec2 {

    public static String longestConsec(String[] words, int k) {

        final int wordsLength = words.length;
        if (k <= 0 || k > wordsLength) {
            return "";
        }
        if (k == wordsLength) {
            return String.join("", words);
        }

        return IntStream.rangeClosed(0, wordsLength - k)
                .mapToObj(i -> Arrays.stream(words, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}

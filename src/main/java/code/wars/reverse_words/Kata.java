package code.wars.reverse_words;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {
    public static String reverseWords(final String original) {

        if (original.isBlank()) {
            return original;
        }

        return Arrays.stream(original.split(" "))
                .map(Kata::reverse)
                .collect(Collectors.joining(" "));
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}

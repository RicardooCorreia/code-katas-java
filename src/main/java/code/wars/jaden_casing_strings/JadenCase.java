package code.wars.jaden_casing_strings;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JadenCase {

    public String toJadenCase(String phrase) {

        if (phrase == null || phrase.isBlank()) {
            return null;
        }

        final Function<String, String> capitalize = word ->
                word.substring(0, 1).toUpperCase(Locale.ROOT) + word.substring(1);

        return Arrays.stream(phrase.split(" "))
                .map(capitalize)
                .collect(Collectors.joining(" "));
    }
}

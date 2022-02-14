package code.wars.most_frequent_words;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopWords {

    public static List<String> top3(String phrase) {

        final String sanitizedPhrase = sanitizePhrase(phrase);

        return Arrays.stream(sanitizedPhrase.split(" "))
                .map(word -> word.replaceAll("^'+$", ""))
                .filter(word -> !word.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static String sanitizePhrase(String phrase) {

        return phrase
                .trim()
                .replaceAll("[^A-Za-z']", " ");
    }
}

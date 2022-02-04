package code.wars.your_order_please;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Order {

    private static final Pattern pattern = Pattern.compile("([1-9]+)");
    public static final String SPACE = " ";
    public static final String EMPTY = "";

    public static String order(String words) {

        if (Objects.equals(words, EMPTY)) {
            return EMPTY;
        }

        return Arrays.stream(words.split(SPACE))
                .map(word -> Map.entry(extractNumber(word), word))
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(SPACE));
    }

    private static Integer extractNumber(String word) {
        final Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        }
        return -1;
    }
}

package code.wars.strip_comments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {

        return Arrays.stream(text.split("\n"))
                .map(line -> line.substring(0, findFirstComment(line, commentSymbols)))
                .map(String::stripTrailing)
                .collect(Collectors.joining("\n"));
    }

    private static int findFirstComment(String line, String[] commentSymbols) {

        return Arrays.stream(commentSymbols)
                .map(line::indexOf)
                .filter(integer -> integer >= 0)
                .min(Comparator.comparingInt(o -> o))
                .orElseGet(line::length);
    }
}

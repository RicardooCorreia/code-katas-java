package code.wars.count_duplicates;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        return (int) text.chars()
                .mapToObj(Character::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .count();
    }
}

package code.wars.ordered_count_of_characters;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public static List<Pair<Character, Integer>> orderedCount(String text) {

        final var map = text.chars()
            .mapToObj(value -> (char) value)
            .collect(groupingBy(identity(), counting()));

        List<Pair<Character, Integer>> result = new ArrayList<>();
        Set<Character> addedChars = new HashSet<>();
        for (var c : text.toCharArray()) {
            if (!addedChars.contains(c)) {
                result.add(Pair.of(c, Math.toIntExact(map.get(c))));
                addedChars.add(c);
            }
        }

        return result;
    }
}

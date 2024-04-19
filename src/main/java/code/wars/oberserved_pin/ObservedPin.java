package code.wars.oberserved_pin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ObservedPin {

    /**
     * ┌───┬───┬───┐
     * │ 1 │ 2 │ 3 │
     * ├───┼───┼───┤
     * │ 4 │ 5 │ 6 │
     * ├───┼───┼───┤
     * │ 7 │ 8 │ 9 │
     * └───┼───┼───┘
     *     │ 0 │
     *     └───┘
     */
    private static final Map<Integer, Set<Integer>> POSSIBLE_REPLACEMENTS = Map.of(
            1, Set.of(1, 2, 4),
            2, Set.of(1, 2, 3, 5),
            3, Set.of(2, 3, 6),
            4, Set.of(1, 4, 5, 7),
            5, Set.of(2, 4, 5, 6, 8),
            6, Set.of(3, 5, 6, 9),
            7, Set.of(4, 7, 8),
            8, Set.of(5, 7, 8, 9, 0),
            9, Set.of(6, 8, 9),
            0, Set.of(0, 8)
    );

    public static List<String> getPINs(String observed) {

        if (observed.isBlank()) {
            return List.of();
        }

        List<Set<Integer>> replacements = Arrays.stream(observed.split(""))
                .map(Integer::valueOf)
                .map(POSSIBLE_REPLACEMENTS::get)
                .toList();

        Set<String> possibilities = getPossibilities(replacements, 0, new HashSet<>(), "");
        return new ArrayList<>(possibilities);
    }

    private static Set<String> getPossibilities(List<Set<Integer>> replacements, int index, Set<String> possibilities, String prefix) {

        if (index >= replacements.size()) {
            possibilities.add(prefix);
            return possibilities;
        }

        Set<Integer> numberReplacement = replacements.get(index);
        for (Integer integer : numberReplacement) {
            possibilities.addAll(getPossibilities(replacements, index + 1, possibilities, prefix + integer));
        }

        return possibilities;
    }
}

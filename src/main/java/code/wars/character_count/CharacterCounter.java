package code.wars.character_count;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CharacterCounter {

    public static boolean validateWord(String word) {

        final Map<Integer, Long> charCounts = word.chars()
            .map(Character::toLowerCase)
            .boxed()
            .collect(groupingBy(identity(), counting()));

        int count = -1;
        for (Long value : charCounts.values()) {
            if (count == -1) {
                count = value.intValue();
            } else if (count != value.intValue()) {
                return false;
            }
        }
        return true;
    }
}

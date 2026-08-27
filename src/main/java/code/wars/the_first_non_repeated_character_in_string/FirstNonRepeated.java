package code.wars.the_first_non_repeated_character_in_string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstNonRepeated {

    public static Character firstNonRepeated(String source) {
        final Set<Character> repeatedCharacters = new HashSet<>();
        final var unique = new LinkedHashSet<Character>();

        for (var c : source.toCharArray()) {
            if (unique.contains(c)) {
                repeatedCharacters.add(c);
                unique.remove(c);
            } else if (!repeatedCharacters.contains(c)) {
                unique.add(c);
            }
        }
        return !unique.isEmpty() ? unique.getFirst() : null;
    }
}

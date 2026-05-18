package code.wars.a_plus_b_equals_123.how_many_unique_consonants;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.*;

public class Kata {

    private static final Set<Character> VOGALS = Set.of('a', 'e', 'i', 'o', 'u');

    public static int countConsonants(String str) {

        final Set<Character> consonants = new HashSet<>();
        for (var c : str.toCharArray()) {
            final var lowerCaseChar = toLowerCase(c);
            if (isAlphabetic(c) && !VOGALS.contains(lowerCaseChar)) {
                consonants.add(lowerCaseChar);
            }
        }

        return consonants.size();
    }
}

package code.wars.disemvowel_trolls;

import java.util.List;
import java.util.stream.Collectors;

public class Troll {

    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static String disemvowel(String str) {

        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !VOWELS.contains(Character.toLowerCase(c)))
                .map(c -> "" + c)
                .collect(Collectors.joining());
    }

    public static String disemvowelRegex(String str) {

        return str.replaceAll("[aeiouAEIOU]", "");
    }
}

package code.wars.anagram_detection;

import java.util.Map;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Kata {
    public static boolean isAnagram(String a, String b) {

        return anagramKey(a).equals(anagramKey(b));
    }

    private static Map<Integer, Long> anagramKey(String a) {
        return a.chars()
            .map(Character::toLowerCase)
            .boxed()
            .collect(groupingBy(identity(), counting()));
    }
}

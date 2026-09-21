package code.wars.count_characters_in_your_string;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static Map<Character, Integer> count(String str) {

        final Map<Character, Integer> result = new HashMap<>();

        for (var c : str.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }

        return result;
    }
}

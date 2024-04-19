package code.wars.vowel_count;

import java.util.List;

public class Vowels {

    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static int getCount(String str) {

        return (int) str.chars()
                .mapToObj(value -> (char) value)
                .filter(VOWELS::contains)
                .count();
    }
}

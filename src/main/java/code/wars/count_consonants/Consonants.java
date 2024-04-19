package code.wars.count_consonants;

import java.util.Locale;

public class Consonants {

    private static final String REGEX = "[b-df-hj-np-tv-z]";

    public static int getCount(String str) {

        return (int) str.chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(s -> s.toLowerCase(Locale.ROOT))
                .filter(s -> s.matches(REGEX))
                .count();
    }
}

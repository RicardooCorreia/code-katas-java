package code.wars.shortest_word;

import java.util.Arrays;
import java.util.Comparator;

public class Kata {

    public static int findShort(String s) {

        return Arrays.stream(s.split(" "))
                .map(String::length)
                .min(Comparator.comparingInt(o -> o))
                .orElseThrow();
    }
}

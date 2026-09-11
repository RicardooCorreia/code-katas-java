package code.wars.find_the_capitals;

import static java.lang.Character.isUpperCase;
import static java.util.stream.IntStream.range;

public class Kata {

    public static int[] capitals(String s) {

        return range(0, s.length())
            .filter(i -> isUpperCase(s.charAt(i)))
            .toArray();
    }
}

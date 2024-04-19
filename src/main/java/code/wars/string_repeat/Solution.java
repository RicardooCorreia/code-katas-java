package code.wars.string_repeat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static String repeatStr(final int repeat, final String string) {

        if (string.isEmpty() || repeat == 0) {
            return "";
        }
        return IntStream.range(0, repeat)
                .mapToObj(value -> string)
                .collect(Collectors.joining());
    }
}


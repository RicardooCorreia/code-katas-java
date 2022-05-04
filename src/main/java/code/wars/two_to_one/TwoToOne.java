package code.wars.two_to_one;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoToOne {

    public static String longest(String s1, String s2) {

        final Stream<Character> stream1 = s1.chars()
                .mapToObj(value -> (char) value);
        final Stream<Character> stream2 = s2.chars()
                .mapToObj(value -> (char) value);

        return Stream
                .concat(stream1, stream2)
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}

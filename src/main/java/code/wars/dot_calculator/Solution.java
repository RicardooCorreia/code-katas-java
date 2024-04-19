package code.wars.dot_calculator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public static String calc(String txt) {

        final String[] components = txt.split(" ");
        final long firstDots = components[0].chars().count();
        final long secondsDots = components[2].chars().count();

        final long finalDots = switch (components[1]) {
            case "+" -> firstDots + secondsDots;
            case "-" -> firstDots - secondsDots;
            case "*" -> firstDots * secondsDots;
            case "//" -> firstDots / secondsDots;
            default -> throw new IllegalStateException("Unexpected value: " + components[1]);
        };

        return IntStream.range(0, (int) finalDots)
                .mapToObj(i -> ".")
                .collect(Collectors.joining());
    }
}

package code.wars.keypad_horror;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Bud {

    private static final Map<String, String> MAPPINGS = Map.of(
        "7", "1",
        "8", "2",
        "9", "3",
        "1", "7",
        "2", "8",
        "3", "9"
    );

    public static String computerToPhone(String number) {

        return stream(number.split(""))
            .map(string -> MAPPINGS.getOrDefault(string, string))
            .collect(joining());
    }
}

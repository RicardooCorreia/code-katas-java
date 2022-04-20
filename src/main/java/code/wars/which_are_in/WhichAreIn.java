package code.wars.which_are_in;

import java.util.Arrays;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {

        return Arrays.stream(array1)
                .filter(s -> Arrays.stream(array2)
                        .anyMatch(word -> word.contains(s)))
                .sorted()
                .toArray(String[]::new);
    }
}

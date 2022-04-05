package code.wars.odd_or_even;

import java.util.Arrays;

public class Codewars {
    public static String oddOrEven (int[] array) {

        if (array.length == 0) {
            return "even";
        }

        return Arrays.stream(array)
                .sum() % 2 == 0 ? "even" : "odd";
    }
}

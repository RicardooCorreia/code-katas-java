package code.wars.largest_5_digits;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestFiveDigitNumber {

    public static int solve(final String digits) {

        final char[] chars = digits.toCharArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length - 4; i++) {
            final String numberString = IntStream.rangeClosed(i, i + 4)
                    .mapToObj(value -> chars[value])
                    .map(character -> "" + character)
                    .collect(Collectors.joining(""));

            final int number = Integer.parseInt(numberString);
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}

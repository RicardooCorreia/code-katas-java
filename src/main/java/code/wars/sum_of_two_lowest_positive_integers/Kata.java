package code.wars.sum_of_two_lowest_positive_integers;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Kata {

    public static long sumTwoSmallestNumbers(long[] numbers) {

        if (numbers == null || numbers.length <= 1) {
            return 0L;
        }

        var minNumber1 = min(numbers[0], numbers[1]);
        var minNumber2 = max(numbers[0], numbers[1]);

        for (int i = 2; i < numbers.length; i++) {
            final long number = numbers[i];

            if (number < minNumber1) {
                minNumber2 = minNumber1;
                minNumber1 = number;
            } else if (number < minNumber2) {
                minNumber2 = number;
            }
        }

        return minNumber1 + minNumber2;
    }
}

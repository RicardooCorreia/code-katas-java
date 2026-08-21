package code.wars.the_three_amigos;

import static java.lang.Math.abs;
import static java.util.Arrays.stream;

public class Dinglemouse {

    public static int[] threeAmigos(final int[] numbers) {

        int[] result = new int[0];
        long range = Long.MAX_VALUE;
        for (var i = 2; i < numbers.length; i++) {

            final var number1 = numbers[i - 2];
            final var number2 = numbers[i - 1];
            final var number3 = numbers[i];

            if (hasSameParity(number1, number2, number3)) {
                final var currentRange = calculateRange(number1, number2, number3);
                if (currentRange < range) {
                    result = new int[]{number1, number2, number3};
                    range = currentRange;
                }
            }
        }
        return result;
    }

    private static long calculateRange(int number1, int number2, int number3) {
        int max = max(number1, number2, number3);
        int min = min(number1, number2, number3);
        var currentRange = (long) max - min;
        return currentRange;
    }

    private static boolean hasSameParity(int number1, int number2, int number3) {
        return abs(number1) % 2 == abs(number2) % 2 && abs(number1) % 2 == abs(number3) % 2;
    }

    private static int max(int... numbers) {
        return stream(numbers)
            .max()
            .orElseThrow();
    }

    private static int min(int... numbers) {
        return stream(numbers)
            .min()
            .orElseThrow();
    }
}

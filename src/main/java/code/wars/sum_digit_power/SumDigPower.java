package code.wars.sum_digit_power;

import java.util.List;
import java.util.stream.LongStream;

class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {

        return LongStream.rangeClosed(a, b)
                .parallel()
                .filter(SumDigPower::equalToSumOfPowerOfNumbers)
                .boxed()
                .toList();
    }

    private static boolean equalToSumOfPowerOfNumbers(long l) {

        if (l < 10) {
            return true;
        }

        final String numberString = String.valueOf(l);

        final char[] chars = numberString.toCharArray();
        long sum = 0;
        for (int i = 0; i < chars.length; i++) {

            long number = chars[i] - 48;
            sum += Math.pow(number, i + 1);
        }

        return sum == l;
    }
}

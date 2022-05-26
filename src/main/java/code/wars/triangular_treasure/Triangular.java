package code.wars.triangular_treasure;

import java.math.BigDecimal;

public class Triangular {

    public static long triangular(long n) {

        if (n < 1) return 0;

        final double number = n;
        final BigDecimal part1 = BigDecimal.valueOf(number / 2);
        final BigDecimal part2 = BigDecimal.valueOf(number + 1);
        final BigDecimal result = part1.multiply(part2);
        return result.longValue();
    }
}

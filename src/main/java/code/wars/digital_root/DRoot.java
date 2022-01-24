package code.wars.digital_root;

import java.util.function.IntUnaryOperator;

public class DRoot {

    public static int digital_root(int n) {

        if (n < 10) {
            return n;
        } else if (n == 10) {
            return 10;
        } else {
            return digital_root(sumNumbers(n));
        }
    }

    private static int sumNumbers(int n) {
        return String.valueOf(n).chars()
                .map(convertCharToInt())
                .filter(value -> value != 0)
                .sum();
    }

    private static IntUnaryOperator convertCharToInt() {
        return value -> value - 48;
    }
}

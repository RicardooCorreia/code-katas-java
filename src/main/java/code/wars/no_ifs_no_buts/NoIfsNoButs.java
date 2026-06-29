package code.wars.no_ifs_no_buts;

import static java.lang.Integer.compare;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class NoIfsNoButs {

    public static String noIfsNoButs(int a, int b) {

        final var compare = min(max(-1, compare(a, b)), 1);
        final String operator = switch (compare) {
            case 1 -> "greater than ";
            case 0 -> "equal to ";
            case -1 -> "smaller than ";
            default -> throw new IllegalStateException("Unexpected value: " + compare);
        };
        return a + " is " + operator + b;
    }
}

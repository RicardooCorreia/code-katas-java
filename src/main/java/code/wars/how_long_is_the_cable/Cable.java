package code.wars.how_long_is_the_cable;

import java.math.BigInteger;
import java.util.Map;

public final class Cable {

    private static final Map<Character, Integer> LENGTHS = Map.of(
        '-', 1,
        '_', 2,
        '=', 3
    );

    public static BigInteger calculateLength(String cable) {
        return BigInteger.valueOf(calculateLength(cable.toCharArray(), 0, cable.length()));
    }

    private static long calculateLength(char[] charArray, int from, int to) {
        long total = 0;
        for (int i = from; i < to; i++) {
            var c = charArray[i];
            total += switch (c) {
                case '-', '_', '=' -> LENGTHS.get(c);
                case '(' -> subcableLength(charArray, i);
                default -> 0;
            };
        }
        return total;
    }

    private static long subcableLength(char[] charArray, int start) {
        final int startIndex = start + 1;
        int depth = 0;
        for (int j = startIndex; j < charArray.length; j++) {
            var c = charArray[j];
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                if (depth == 0) {
                    return calculateLength(charArray, startIndex, j);
                }
                depth--;
            }
        }
        return 0;
    }
}
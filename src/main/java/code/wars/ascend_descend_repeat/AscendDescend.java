package code.wars.ascend_descend_repeat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AscendDescend {

    public static String ascendDescend(int length, int minimum, int maximum) {

        if (maximum == minimum) {
            return IntStream.range(0, length)
                    .mapToObj(i -> String.valueOf(minimum))
                    .collect(Collectors.joining());
        } else if (minimum > maximum) {
            return "";
        }

        return returnAscendDescend(length, minimum, maximum);
    }

    private static String returnAscendDescend(int length, int minimum, int maximum) {
        int current = minimum;
        int factor = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {

            if (current < 0) i++;
            stringBuilder.append(current);
            current += factor;
            factor = setFactor(minimum, maximum, current, factor);
        }
        return stringBuilder.substring(0, length);
    }

    private static int setFactor(int minimum, int maximum, int current, int factor) {

        if (current == maximum) {
            factor = -1;
        } else if (current == minimum) {
            factor = 1;
        }
        return factor;
    }
}

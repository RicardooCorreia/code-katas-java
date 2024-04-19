package code.wars.roman_numerals_encoder;

import java.util.Map;
import java.util.stream.Collectors;

public class Conversion {

    private static final Map<Integer, String> SYMBOLS = Map.of(
            1, "I",
            5, "V",
            10, "X",
            50, "L",
            100, "C",
            500, "D",
            1000, "M");

    public String solution(int input) {

        final String numberString = Integer.toString(input);
        final int firstNumber = Integer.parseInt(numberString.substring(0, 1));
        final String rest = numberString.substring(1);
        final int restNumber = rest.length() > 0 ? Integer.parseInt(rest) : 0;
        final int orderOfMagnitude = Integer.parseInt("1" + rest.chars().mapToObj(c -> "0").collect(Collectors.joining()));

        final StringBuilder stringBuilder = new StringBuilder();

        if (firstNumber <= 3) {
            for (int i = 0; i < firstNumber; i++) {
                stringBuilder.append(SYMBOLS.get(orderOfMagnitude));
            }
        } else if (firstNumber == 4) {
            stringBuilder.append(SYMBOLS.get(orderOfMagnitude)).append(SYMBOLS.get(5 * orderOfMagnitude));
        } else if (firstNumber == 5) {
            stringBuilder.append(SYMBOLS.get(5 * orderOfMagnitude));
        } else if (firstNumber == 6) {
            stringBuilder.append(SYMBOLS.get(5 * orderOfMagnitude)).append(SYMBOLS.get(orderOfMagnitude));
        } else if (firstNumber <= 8) {
            stringBuilder.append(SYMBOLS.get(5 * orderOfMagnitude));
            for (int i = 5; i < firstNumber; i++) {
                stringBuilder.append(SYMBOLS.get(orderOfMagnitude));
            }
        } else if (firstNumber == 9) {
            stringBuilder.append(SYMBOLS.get(orderOfMagnitude)).append(SYMBOLS.get(10 * orderOfMagnitude));
        } else if (firstNumber == 10) {
            stringBuilder.append(SYMBOLS.get(10 * orderOfMagnitude));
        }

        if (restNumber > 0) {
            return stringBuilder.append(solution(restNumber)).toString();
        } else {
            return stringBuilder.toString();
        }
    }
}

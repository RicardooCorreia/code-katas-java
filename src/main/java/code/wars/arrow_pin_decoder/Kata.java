package code.wars.arrow_pin_decoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Kata {

    private static final Set<Integer> INVALID_RIGHT = Set.of(9, 6, 3, 0);
    private static final Set<Integer> INVALID_LEFT = Set.of(7, 4, 1, 0);
    private static final Set<Integer> INVALID_DOWN = Set.of(0, 2, 3);
    private static final Set<Integer> INVALID_UP = Set.of(7, 8, 9);

    public static int[] decArrowPinCode(String arrowStr) {

        char[] parts = arrowStr.toCharArray();
        List<Integer> results = new ArrayList<>();

        int currentNumber = getNumberFromChar(parts[0]);
        results.add(currentNumber);

        for (int i = 1; i < parts.length; i++) {

            char part = parts[i];
            if (part == '*') {
                int times = getNumberFromChar(parts[i + 1]);
                for (int n = 0; n < times; n++) {
                    results.add(currentNumber);
                }
                i++;
            } else {
                Optional<Integer> optional = calculateMove(part, currentNumber);
                if (optional.isPresent()) {
                    currentNumber = optional.get();
                    results.add(currentNumber);
                } else {
                    return new int[]{};
                }

            }

        }

        return results.stream().mapToInt(value -> value).toArray();
    }

    private static int getNumberFromChar(char c) {
        return c - 48;
    }

    private static Optional<Integer> calculateMove(char part, int currentNumber) {
        switch (part) {
            case '→':
                return returnValidNumberOrEmpty(INVALID_RIGHT, currentNumber, currentNumber + 1);
            case '←':
                return returnValidNumberOrEmpty(INVALID_LEFT, currentNumber, currentNumber - 1);
            case '↑':
                return returnValidNumberOrEmpty(INVALID_UP, currentNumber, currentNumber == 0 ? 1 : currentNumber + 3);
            case '↓':
                return returnValidNumberOrEmpty(INVALID_DOWN, currentNumber, currentNumber == 1 ? 0 : currentNumber - 3);
        }
        return Optional.empty();
    }

    private static Optional<Integer> returnValidNumberOrEmpty(Set<Integer> invalidOptions, int currentNumber, int numberAfterMove) {
        if (invalidOptions.contains(currentNumber)) return Optional.empty();
        return Optional.of(numberAfterMove);
    }
}

package code.wars.kingdoms.jousting;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kata {

    private static final Character LEFT_KNIGHT_SPEAR = '>';

    private static final Character RIGHT_KNIGHT_SPEAR = '<';

    static String[] joust(String[] listField, int vKnightLeft, int vKnightRight) {

        if (vKnightLeft == 0 && vKnightRight == 0) {
            return listField;
        }

        String leftKnightField = listField[0];
        String rightKnightField = listField[1];

        return run(leftKnightField, rightKnightField, vKnightLeft, vKnightRight);
    }

    private static String[] run(String leftKnightField,
                                String rightKnightField,
                                int vKnightLeft,
                                int vKnightRight) {

        int leftSpearIndex = leftKnightField.indexOf(LEFT_KNIGHT_SPEAR);
        int rightSpearIndex = rightKnightField.indexOf(RIGHT_KNIGHT_SPEAR);
        if (leftSpearIndex >= rightSpearIndex) {
            return new String[]{leftKnightField, rightKnightField};
        } else {
            String newLeftField = generateEmptySpaces(vKnightLeft) + leftKnightField.substring(0, leftKnightField.length() - vKnightLeft);
            String newRightField = rightKnightField.substring(vKnightRight) + generateEmptySpaces(vKnightRight);
            return run(newLeftField, newRightField, vKnightLeft, vKnightRight);
        }
    }

    private static String generateEmptySpaces(int vKnightLeft) {

        return Stream.generate(() -> " ")
                .limit(vKnightLeft)
                .collect(Collectors.joining());
    }
}

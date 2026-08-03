package code.wars.sentence_calculator;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isUpperCase;

public class SentenceCalculator {

    public static int lettersToNumbers(String s) {

        return s.chars()
            .map(SentenceCalculator::charValue)
            .sum();
    }

    private static int charValue(int character) {

        final var isLetter = isLetter(character);
        final var isDigit = isDigit(character);
        if (!isLetter && !isDigit) {
            return 0;
        }

        final int multiplier = isUpperCase(character) ? 2 : 1;
        return isLetter ? (Character.toLowerCase(character) - 'a' + 1) * multiplier : character - '0';
    }
}

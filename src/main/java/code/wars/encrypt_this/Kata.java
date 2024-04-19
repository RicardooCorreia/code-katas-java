package code.wars.encrypt_this;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {

    public static final String SPACE = " ";

    public static String encryptThis(String text) {

        return Arrays.stream(text.split(SPACE))
                .map(Kata::replaceSecondWithLastLetter)
                .map(Kata::convertFirstLetterToAscii)
                .collect(Collectors.joining(SPACE));
    }

    private static String replaceSecondWithLastLetter(String input) {

        if (input.length() < 3) {
            return input;
        }

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(input.charAt(0))
                .append(input.charAt(input.length() - 1));

        if (input.length() > 3) {
            stringBuilder.append(input, 2, input.length() - 1);
        }

        return stringBuilder
                .append(input.charAt(1))
                .toString();
    }

    private static String convertFirstLetterToAscii(String input) {

        if (input.isBlank()) {
            return input;
        }

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((int) input.charAt(0));

        final int length = input.length();
        if (length > 1) {
            stringBuilder.append(input, 1, length);
        }
        return stringBuilder.toString();
    }
}

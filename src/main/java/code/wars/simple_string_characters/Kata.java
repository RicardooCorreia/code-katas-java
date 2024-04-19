package code.wars.simple_string_characters;

import java.util.regex.Pattern;

public class Kata {

    public static int[] solve(String word) {

        final Pattern upperCasePattern = Pattern.compile("([A-Z])");
        final Pattern lowerCasePattern = Pattern.compile("([a-z])");
        final Pattern numberPattern = Pattern.compile("(\\d)");

        final int upperCaseCount = (int) upperCasePattern.matcher(word).results().count();
        final int lowerCaseCount = (int) lowerCasePattern.matcher(word).results().count();
        final int numberCount = (int) numberPattern.matcher(word).results().count();

        return new int[]{upperCaseCount, lowerCaseCount, numberCount, word.length() - upperCaseCount - lowerCaseCount - numberCount};
    }
}

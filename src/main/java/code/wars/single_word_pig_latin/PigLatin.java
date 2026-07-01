package code.wars.single_word_pig_latin;

import static java.util.Locale.ROOT;

public class PigLatin {

    private static final String VOWEL_START_PATTERN = "^[aeiou].*";
    private static final String ALPHA_PATTERN = "[a-z]+";
    private static final String NO_VOWEL_PATTERN = "[^aeiou]+";

    public String translate(String str) {

        final var lowerCaseString = str.toLowerCase(ROOT);
        if (!lowerCaseString.matches(ALPHA_PATTERN)) {
            return null;
        } else {
            if (lowerCaseString.matches(VOWEL_START_PATTERN)) {
                return lowerCaseString + "way";
            } else if (lowerCaseString.matches(NO_VOWEL_PATTERN)) {
                return lowerCaseString + "ay";
            } else {
                final var rotatedString = rotateStringUntilValid(lowerCaseString);
                return rotatedString + "ay";
            }
        }
    }

    private String rotateStringUntilValid(String lowerCaseString) {
        var comparingString = lowerCaseString;
        do {
            comparingString = comparingString.substring(1) + comparingString.charAt(0);
        } while (!comparingString.matches(VOWEL_START_PATTERN));
        return comparingString;
    }
}

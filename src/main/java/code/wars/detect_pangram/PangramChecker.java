package code.wars.detect_pangram;

import java.util.Locale;

public class PangramChecker {

    public boolean check(String sentence) {

        int alphabetLength = 26;
        if (sentence.length() < alphabetLength) {
            return false;
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.chars()
                .mapToObj(letter -> String.valueOf((char) letter))
                .filter(letter -> !containsLetter(sentence, letter))
                .findAny()
                .isEmpty();
    }

    private boolean containsLetter(String sentence, String letter) {

        return sentence.contains(letter.toLowerCase(Locale.ROOT)) ||
                sentence.contains(letter.toUpperCase(Locale.ROOT));
    }
}

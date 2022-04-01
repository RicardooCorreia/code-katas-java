package code.wars.kingdoms.the_curse_simplified;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Kata {

    public static final String REGEX = "([a-zA-Z0-9*]+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    static String translate(String speech, String[] vocabulary) {

        if (speech.isBlank()) {
            return "";
        }
        return matchWords(speech, vocabulary);
    }

    private static String matchWords(String speech, String[] vocabulary) {

        final List<String> possibleWords = new ArrayList<>(List.of(vocabulary));
        final StringBuilder completedSpeech = new StringBuilder();
        for (String word : speech.split(" ")) {
            final String wordWithoutSpecialChars = getWordWithoutSpecialChars(word);
            final String completedWord = findMatchingWord(possibleWords, wordWithoutSpecialChars);
            // Remove word, since its 1-1 mapping
            possibleWords.remove(completedWord);
            completedSpeech
                    .append(word.replaceAll(REGEX, completedWord))
                    .append(" ");

        }
        return completedSpeech.toString().trim();
    }

    private static String findMatchingWord(List<String> possibleWords, String wordWithoutSpecialChars) {
        return possibleWords
                .stream()
                .filter(possibleWord -> possibleWord.length() == wordWithoutSpecialChars.length())
                .filter(possibleWord -> matches(possibleWord, wordWithoutSpecialChars))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No word found"));
    }

    private static String getWordWithoutSpecialChars(String word) {
        final Matcher matcher = PATTERN.matcher(word);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("No match found for word: " + word);
        }
    }

    private static boolean matches(String possibleWord, String wordWithoutSpecialChars) {

        for (int i = 0; i < possibleWord.length(); i++) {
            final char charAt = wordWithoutSpecialChars.charAt(i);
            if (charAt != '*' && charAt != possibleWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

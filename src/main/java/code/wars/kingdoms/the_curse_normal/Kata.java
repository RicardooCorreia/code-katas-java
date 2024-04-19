package code.wars.kingdoms.the_curse_normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {

    public static final String SPACE = " ";

    public static final char CURSED_LETTER = '*';

    public static String translate(String speech, String[] vocabulary) {

        if (speech.isBlank()) {
            return speech;
        }

        List<String> vocabularyList = Arrays.asList(vocabulary);
        Map<String, List<String>> translationOptions = new HashMap<>();
        String[] splitSpeech = speech.split(SPACE);
        for (String word : splitSpeech) {
            translationOptions.put(word, translateWord(word, vocabularyList));
        }
        return findCorrectTranslations(translationOptions, vocabularyList, splitSpeech);
    }

    private static String findCorrectTranslations(Map<String, List<String>> translationOptions,
                                                  List<String> vocabularyList,
                                                  String[] splitSpeech) {

        ArrayList<String> availableWords = new ArrayList<>(vocabularyList);
        Map<String, String> translations = translationOptions.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                .map(translationOption -> {
                    String originalWord = translationOption.getKey();
                    List<String> options = translationOption.getValue();
                    String chosenOption = options.stream()
                            .filter(availableWords::contains)
                            .findFirst()
                            .orElseThrow();
                    availableWords.remove(chosenOption);
                    return Map.entry(originalWord, chosenOption);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : splitSpeech) {
            String translation = translations.get(word);
            String translationWithSymbols = word.replace(wordWithoutSymbols(word), translation);
            stringBuilder
                    .append(translationWithSymbols)
                    .append(SPACE);
        }
        return stringBuilder.toString().trim();
    }

    private static List<String> translateWord(String word, List<String> vocabularyList) {

        return vocabularyList.stream()
                .filter(vocabularyWord -> vocabularyWord.length() == wordLengthWithoutSymbols(word))
                .filter(vocabularyWord -> corresponds(word, vocabularyWord))
                .toList();
    }

    private static int wordLengthWithoutSymbols(String word) {

        return wordWithoutSymbols(word).length();
    }

    private static String wordWithoutSymbols(String word) {

        return IntStream.range(0, word.length())
                .filter(i -> {
                    char letter = word.charAt(i);
                    return Character.isAlphabetic(letter) || letter == CURSED_LETTER;
                })
                .mapToObj(word::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static boolean corresponds(String word, String vocabularyWord) {

        return IntStream.range(0, word.length())
                .allMatch(i -> {
                    char letter = word.charAt(i);
                    return !Character.isAlphabetic(letter) || vocabularyWord.charAt(i) == letter;
                });
    }
}

package code.wars.format_words_into_sentence;

import java.util.Arrays;
import java.util.List;

public class Kata {

    public static String formatWords(String[] words) {

        if (words == null || words.length == 0) {
            return "";
        }

        List<String> notEmptyWords = Arrays.stream(words)
                .filter(s -> !s.isBlank())
                .toList();

        if (notEmptyWords.size() == 1) {
            return notEmptyWords.get(0);
        } else if (notEmptyWords.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int lastIndex = notEmptyWords.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            stringBuilder.append(notEmptyWords.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " and ");
        stringBuilder.append(notEmptyWords.get(lastIndex));
        return stringBuilder.toString();
    }
}

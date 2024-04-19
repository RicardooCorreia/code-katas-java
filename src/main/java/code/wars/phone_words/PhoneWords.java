package code.wars.phone_words;

import java.util.List;
import java.util.Map;

public class PhoneWords {

    private static final Map<Integer, List<Character>> PHONE = Map.of(
            2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'),
            4, List.of('g', 'h', 'i'),
            5, List.of('j', 'k', 'l'),
            6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'),
            8, List.of('t', 'u', 'v'),
            9, List.of('w', 'x', 'y', 'z')
    );

    public static String phoneWords(String str) {

        if (str == null || str.isBlank()) {
            return str;
        }

        int previousNumber = -1;
        int previousNumberMaxCount = -1;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            int number = c - 48;
            boolean isStartingSegment = previousNumber == -1 && number > 1;
            boolean isContinuingSegment = previousNumber == number && count < previousNumberMaxCount;
            if (isStartingSegment) {
                previousNumber = number;
                previousNumberMaxCount = PHONE.get(number).size();
                count++;
            } else if (isContinuingSegment) {
                count++;
            } else {
                appendLetterIfValid(previousNumber, count, stringBuilder);
                if (number == 0) {
                    previousNumber = -1;
                    stringBuilder.append(" ");
                    count = 0;
                } else if (number == 1) {
                    count = 0;
                    previousNumber = -1;
                } else {
                    previousNumber = number;
                    count = 1;
                    previousNumberMaxCount = PHONE.get(number).size();
                }
            }
        }

        appendLetterIfValid(previousNumber, count, stringBuilder);
        return stringBuilder.toString();
    }

    private static void appendLetterIfValid(int previousNumber, int count, StringBuilder stringBuilder) {

        if (previousNumber != -1) {
            Character character = PHONE.get(previousNumber).get(count - 1);
            stringBuilder.append(character);
        }
    }
}

package haker.rank.happy_ladybugs;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

class Result {

    public static final char EMPTY_SPACE = '_';
    public static final String YES = "YES";
    public static final String NO = "NO";
    public static final char NO_CHAR = ' ';

    public static String happyLadybugs(String b) {

        final char[] chars = b.toCharArray();
        final boolean hasEmptySpaces = b.indexOf(EMPTY_SPACE) == -1;
        if (hasEmptySpaces) {
            return checkLadyBugsAreAlreadyHappy(chars);
        } else {
            return calculateIfLadyBugsCanBeHappy(chars);
        }
    }

    private static String calculateIfLadyBugsCanBeHappy(char[] chars) {
        final Optional<Integer> singleLadyBug = findSingleLadyBug(chars);
        if (singleLadyBug.isPresent()) {
            return NO;
        } else {
            return YES;
        }
    }

    private static Map<Character, Integer> countLadyBugsByColor(char[] chars) {
        final Map<Character, Integer> ladyBugCount = new HashMap<>();
        for (char c : chars) {
            ladyBugCount.putIfAbsent(c, 0);
            ladyBugCount.put(c, ladyBugCount.get(c) + 1);
        }
        return ladyBugCount;
    }

    private static Optional<Integer> findSingleLadyBug(char[] chars) {

        final Map<Character, Integer> ladyBugCount = countLadyBugsByColor(chars);

        return ladyBugCount.entrySet()
                .stream()
                .filter(characterIntegerEntry -> !characterIntegerEntry.getKey().equals(EMPTY_SPACE))
                .map(Map.Entry::getValue)
                .filter(integer -> integer < 2)
                .findAny();
    }

    private static String checkLadyBugsAreAlreadyHappy(char[] chars) {

        final int length = chars.length;
        if (length < 2) {
            return NO;
        }

        for (int i = 1; i < length; i++) {
            final char aChar = chars[i];
            final char previousChar = chars[i - 1];
            if (aChar != previousChar && aChar != getNextChar(chars, i)) {
                return NO;
            }
        }
        return YES;
    }

    private static char getNextChar(char[] chars, int i) {

        return i == chars.length - 1 ? NO_CHAR : chars[i + 1];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

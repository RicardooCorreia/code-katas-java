package code.wars.character_with_longest_consecutive_repetition;

public class Solution {

    public static Object[] longestRepetition(String s) {

        if (s.isBlank()) {
            return new Object[]{"", 0};
        }

        char[] chars = s.toCharArray();

        char maxStreakChar = ' ';
        int maxCount = Integer.MIN_VALUE;

        char currentChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == currentChar) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxStreakChar = currentChar;
                }
                currentChar = aChar;
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            maxStreakChar = currentChar;
        }

        return new Object[]{String.valueOf(maxStreakChar), maxCount};
    }
}

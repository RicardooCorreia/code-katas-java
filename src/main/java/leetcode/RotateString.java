package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RotateString {

    static class Solution {
        public boolean rotateString(String s, String goal) {

            if (s.length() != goal.length()) return false;

            Map<String, Map<String, Integer>> nextLetters = getNextLetters(s);
            Map<String, Map<String, Integer>> nextLettersGoal = getNextLetters(goal);
            return nextLetters.equals(nextLettersGoal);
        }

        private static Map<String, Map<String, Integer>> getNextLetters(String s) {
            String[] letters = s.split("");
            Map<String, Map<String, Integer>> nextLetters = new HashMap<>();
            for (int i = 0; i < letters.length; i++) {
                int nextIndex = i + 1;
                if (nextIndex == letters.length) {
                    nextIndex = 0;
                }
                String letter = letters[i];
                String nextLetter = letters[nextIndex];
                nextLetters.putIfAbsent(letter, new HashMap<>());
                Integer count = Optional.ofNullable(nextLetters.get(letter).get(nextLetter)).orElse(0);
                nextLetters.get(letter).put(nextLetter, count + 1);
            }
            return nextLetters;
        }
    }

    static class Solution2 {
        public boolean rotateString(String s, String goal) {

            StringBuilder rotating = new StringBuilder(s);
            int lastIndex = s.length() - 1;
            do {
                char letterToShift = rotating.charAt(lastIndex);
                rotating.insert(0, letterToShift);
                rotating.deleteCharAt(s.length());

                if (rotating.toString().equals(goal)) {
                    return true;
                }

            } while (!rotating.toString().equals(s));

            return false;
        }
    }
}

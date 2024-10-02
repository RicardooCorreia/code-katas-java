package leetcode;

public class DetectCapital {

    static class Solution {
        public boolean detectCapitalUse(String word) {

            if (word.length() == 1) {
                return true;
            }

            String[] letters = word.split("");
            String firstLetter = letters[0];
            if (isUpperCase(firstLetter)) {
                String secondLetter = letters[1];
                return isUpperCase(secondLetter) ?
                        isAllUpperCase(letters, 2) : // validate all capital
                        isAllLowerCase(letters, 2); // validate camel case

            } else {
                return isAllLowerCase(letters, 1); // validate all lower case
            }
        }

        private static boolean isAllLowerCase(String[] letters, int startIndex) {
            for (int i = startIndex; i < letters.length; i++) {
                if (isUpperCase(letters[i])) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isAllUpperCase(String[] letters, int startIndex) {
            for (int i = startIndex; i < letters.length; i++) {
                if (!isUpperCase(letters[i])) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isUpperCase(String letter) {
            return letter.equals(letter.toUpperCase());
        }
    }
}

package leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 *      Input: s = "babad"
 *      Output: "bab"
 *      Explanation: "aba" is also a valid answer.
 * Example 2:
 *      Input: s = "cbbd"
 *      Output: "bb"
 * Constraints:
 *      1 <= s.length <= 1000
 *      s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    static class Solution {
        public String longestPalindrome(String s) {

            int length = s.length();
            if (length < 2) {
                return s;
            }

            String maxString = "";
            for (int i = 0; i < length - 1; i++) {
                String middleOfTheLetters = expandFromCenter(i, i, length, s);
                String middleLetter = expandFromCenter(i, i + 1, length, s);

                if (middleOfTheLetters.length() > maxString.length()) {
                    maxString = middleOfTheLetters;
                }

                if (middleLetter.length() > maxString.length()) {
                    maxString = middleLetter;
                }
            }

            return maxString;
        }

        private String expandFromCenter(int left, int right, int maxLength, String string) {

            while (left >= 0 && right < maxLength && string.charAt(left) == string.charAt(right)) {
                left--;
                right++;
            }

            return string.substring(left + 1, right);
        }
    }
}

package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * <p>
 * Example 1:
 *      Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 *      Output: true
 *      Explanation:
 *          word1 represents string "ab" + "c" -> "abc"
 *          word2 represents string "a" + "bc" -> "abc"
 *          The strings are the same, so return true.
 * Example 2:
 *      Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 *      Output: false
 * Example 3:
 *      Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 *      Output: true
 * <p>
 * Constraints:
 *      1 <= word1.length, word2.length <= 103
 *      1 <= word1[i].length, word2[i].length <= 103
 *      1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 *      word1[i] and word2[i] consist of lowercase letters.
 */
public class CheckIfTwoStringArraysAreEquivalent {

    static class Solution {

        public boolean arrayStringsAreEqual(String[] words1, String[] words2) {

            return String.join("", words1).equals(String.join("", words2));
        }

        public boolean arrayStringsAreEqual2(String[] words1, String[] words2) {

            int[] letters1 = getLetters(words1);
            int[] letters2 = getLetters(words2);

            if (letters1.length != letters2.length) return false;

            for (int i = 0; i < letters1.length; i++) {
                if (letters1[i] != letters2[i]) return false;
            }

            return true;
        }

        private static int[] getLetters(String[] words) {
            return Arrays.stream(words)
                    .flatMapToInt(String::chars)
                    .toArray();
        }
    }
}

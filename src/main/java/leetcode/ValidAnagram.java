package leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 *      Input: s = "anagram", t = "nagaram"
 *      Output: true
 * Example 2:
 *      Input: s = "rat", t = "car"
 *      Output: false
 * Constraints:
 *      1 <= s.length, t.length <= 5 * 104
 *      s and t consist of lowercase English letters.
 */
public class ValidAnagram {

    static class Solution {
        public boolean isAnagram(String s, String t) {

            return getAnagramKey(s).equals(getAnagramKey(t));
        }

        private static Map<Integer, Long> getAnagramKey(String s) {
            return s.chars()
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }
}

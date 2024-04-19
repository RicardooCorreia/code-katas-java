package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 *  No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Example 1:
 *      Input: s = "egg", t = "add"
 *      Output: true
 * Example 2:
 *      Input: s = "foo", t = "bar"
 *      Output: false
 * Example 3:
 *      Input: s = "paper", t = "title"
 *      Output: true
 * <p>
 * Constraints:
 *      1 <= s.length <= 5 * 104
 *      t.length == s.length
 *      s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {

    static class Solution {
        public boolean isIsomorphic(String input1, String input2) {

            if (input1.length() != input2.length()) return false;

            Map<Character, Character> corresponding1 = new HashMap<>();
            Map<Character, Character> corresponding2 = new HashMap<>();

            for (int i = 0; i < input1.length(); i++) {
                char char1 = input1.charAt(i);
                char char2 = input2.charAt(i);

                if (!corresponding1.containsKey(char1)) {
                    corresponding1.put(char1, char2);
                } else if (corresponding1.get(char1) != char2) {
                    return false;
                }

                if (!corresponding2.containsKey(char2)) {
                    corresponding2.put(char2, char1);
                } else if (corresponding2.get(char2) != char1) {
                    return false;
                }
            }

            return true;
        }
    }
}

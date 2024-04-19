package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *      Input: s = "abcabcbb"
 *      Output: 3
 *      Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *      Input: s = "bbbbb"
 *      Output: 1
 *      Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *      Input: s = "pwwkew"
 *      Output: 3
 *      Explanation: The answer is "wke", with the length of 3.
 *      Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 *      0 <= s.length <= 5 * 104
 *      s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {


            if (s == null || s.isEmpty()) {
                return 0;
            } else if (s.length() == 1) {
                return 1;
            }

            int length = s.length();

            return IntStream.range(0, length)
                    .map(index -> {
                        Set<Character> chars = new HashSet<>();
                        chars.add(s.charAt(index));
                        int currentLength = 1;
                        for (int j = index + 1; j < length; j++) {
                            char c = s.charAt(j);
                            if (chars.contains(c)) {
                                break;
                            } else {
                                chars.add(c);
                                currentLength++;
                            }
                        }

                        return currentLength;
                    })
                    .max()
                    .getAsInt();
        }
    }
}

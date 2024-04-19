package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 *      Input: strs = ["flower","flow","flight"]
 *      Output: "fl"
 * Example 2:
 *      Input: strs = ["dog","racecar","car"]
 *      Output: ""
 *      Explanation: There is no common prefix among the input strings.
 * Constraints:
 *      1 <= strs.length <= 200
 *      0 <= strs[i].length <= 200
 *      strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {


            int minLength = Arrays.stream(strs)
                    .map(String::length)
                    .min(Comparator.comparingInt(o -> o))
                    .get();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < minLength; i++) {

                char letter = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != letter) return stringBuilder.toString();
                }
                stringBuilder.append(letter);
            }
            return stringBuilder.toString();
        }
    }
}

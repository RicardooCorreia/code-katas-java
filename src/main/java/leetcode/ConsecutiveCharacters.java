package leetcode;

/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.
Given a string s, return the power of s.

Example 1:
    Input: s = "leetcode"
    Output: 2
    Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:
    Input: s = "abbcccddddeeeeedcba"
    Output: 5
    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

Constraints:
    1 <= s.length <= 500
    s consists of only lowercase English letters.
 */
public class ConsecutiveCharacters {

    static class Solution {
        public int maxPower(String s) {

            char previousChar = s.charAt(0);
            int currentCount = 1, maxCount = currentCount;
            for (int i = 1; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (currentChar == previousChar) {
                    currentCount++;
                } else {
                    previousChar = currentChar;
                    maxCount = Math.max(currentCount, maxCount);
                    currentCount = 1;
                }
            }
            return Math.max(currentCount, maxCount);
        }
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t.

Example 1:
    Input: s = "abcd", t = "abcde"
    Output: "e"
    Explanation: 'e' is the letter that was added.
Example 2:
    Input: s = "", t = "y"
    Output: "y"

Constraints:
    0 <= s.length <= 1000
    t.length == s.length + 1
    s and t consist of lowercase English letters.
 */
public class FindTheDifference {
    static class Solution {
        public char findTheDifference(String s, String t) {

            Map<Character, Integer> charCount = new HashMap<>();

            String bigger = s.length() > t.length() ? s : t;
            String smaller = s.length() > t.length() ? t : s;

            for (char c : bigger.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            for (char c : smaller.toCharArray()) {
                if (!charCount.containsKey(c)) {
                    return c;
                } else {

                    int newCharCount = charCount.get(c) - 1;
                    if (newCharCount == 0) {
                        charCount.remove(c);
                    } else {
                        charCount.put(c, newCharCount);
                    }
                }
            }

            return charCount.keySet().iterator().next();
        }
    }
}

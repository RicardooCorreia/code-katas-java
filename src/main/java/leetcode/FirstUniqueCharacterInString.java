package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
    Input: s = "leetcode"
    Output: 0
Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
    Input: s = "loveleetcode"
    Output: 2

Example 3:
    Input: s = "aabb"
    Output: -1

Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.
 */
public class FirstUniqueCharacterInString {

    static class Solution {
        public int firstUniqChar(String s) {

            Map<Character, Integer> uniqueIndexes = new HashMap<>();
            Set<Character> foundCharacters = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (foundCharacters.contains(c)) {
                    uniqueIndexes.remove(c);
                } else {
                    foundCharacters.add(c);
                    uniqueIndexes.put(c, i);
                }
            }

            return uniqueIndexes.values().stream()
                    .mapToInt(value -> value)
                    .min()
                    .orElse(-1);
        }
    }
}

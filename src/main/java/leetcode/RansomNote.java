package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 *      Input: ransomNote = "a", magazine = "b"
 *      Output: false
 * Example 2:
 *      Input: ransomNote = "aa", magazine = "ab"
 *      Output: false
 * Example 3:
 *      Input: ransomNote = "aa", magazine = "aab"
 *      Output: true
 * <p>
 * Constraints:
 *      1 <= ransomNote.length, magazine.length <= 105
 *      ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            Map<Character, Long> letterInventory = getLetterCount(magazine);
            Map<Character, Long> lettersNeeded = getLetterCount(ransomNote);
            return lettersNeeded.entrySet().stream()
                    .allMatch(letterNeeded -> letterInventory.containsKey(letterNeeded.getKey()) &&
                            letterInventory.get(letterNeeded.getKey()) >= letterNeeded.getValue());
        }

        private static Map<Character, Long> getLetterCount(String magazine) {
            return magazine.chars()
                    .mapToObj(value -> (char) value)
                    .collect(Collectors.groupingBy(value -> value, Collectors.counting()));
        }
    }
}

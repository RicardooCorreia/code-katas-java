package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.

Example 1:
    Input: s = "a1b2"
    Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:
    Input: s = "3z4"
    Output: ["3z4","3Z4"]

Constraints:
    1 <= s.length <= 12
    s consists of lowercase English letters, uppercase English letters, and digits.
 */
public class LetterCasePermutation {

    static class Solution {
        public List<String> letterCasePermutation(String s) {

            char[] chars = s.toCharArray();
            return letterCasePermutation(chars, 0, List.of(""));
        }

        private List<String> letterCasePermutation(char[] chars, int index, List<String> currentPermutations) {

            if (index == chars.length) {
                return currentPermutations;
            }

            char aChar = chars[index];
            List<Character> variations = getVariations(aChar);
            List<String> newPermutations = new ArrayList<>();
            for (Character variation : variations) {
                for (String permutation : currentPermutations) {
                    newPermutations.add(permutation + variation);
                }
            }

            return letterCasePermutation(chars, index + 1, newPermutations);
        }

        private List<Character> getVariations(char aChar) {

            if (Character.isDigit(aChar)) {
                return List.of(aChar);
            } else {
                return List.of(Character.toLowerCase(aChar), Character.toUpperCase(aChar));
            }
        }
    }
}

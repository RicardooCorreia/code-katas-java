package leetcode;

import java.util.ArrayList;
import java.util.List;

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

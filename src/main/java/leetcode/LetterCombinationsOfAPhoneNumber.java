package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 *      Input: digits = "23"
 *      Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *      Input: digits = ""
 *      Output: []
 * Example 3:
 *      Input: digits = "2"
 *      Output: ["a","b","c"]
 * <p>
 *  Constraints:
 *      0 <= digits.length <= 4
 *      digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfAPhoneNumber {

    static class Solution {

        private static final Map<Character, List<Character>> NUMBERS = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );

        public List<String> letterCombinations(String digits) {

            if (digits.isEmpty()) {
                return List.of();
            }

            List<List<Character>> letters = digits.chars()
                    .mapToObj(c -> NUMBERS.get((char) c))
                    .toList();

            return combinations(letters);
        }

        private List<String> combinations(List<List<Character>> lettersList) {

            return getRecursivePermutations(new LinkedList<>(), lettersList);
        }

        private List<String> getRecursivePermutations(List<String> currentPermutations, List<List<Character>> lettersList) {

            List<Character> characters = lettersList.get(0);
            List<String> result = new LinkedList<>();
            for (Character c : characters) {
                addToPermutations(currentPermutations, c, result);
            }
            if (lettersList.size() <= 1) {
                return result;
            } else {
                return getRecursivePermutations(result, lettersList.subList(1, lettersList.size()));
            }
        }

        private static void addToPermutations(List<String> currentPermutations, Character c, List<String> result) {
            if (currentPermutations.isEmpty()) {
                result.add(String.valueOf(c));
            } else {
                for (String permutation : currentPermutations) {
                    result.add(permutation + c);
                }
            }
        }
    }
}

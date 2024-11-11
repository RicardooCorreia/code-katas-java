package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
You are given a string word that consists of digits and lowercase English letters.
You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34".
 Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
Return the number of different integers after performing the replacement operations on word.
Two integers are considered different if their decimal representations without any leading zeros are different.

Example 1:
    Input: word = "a123bc34d8ef34"
    Output: 3
    Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
Example 2:
    Input: word = "leet1234code234"
    Output: 2
Example 3:
    Input: word = "a1b01c001"
    Output: 1
    Explanation: The three integers "1", "01", and "001" all represent the same integer because
    the leading zeros are ignored when comparing their decimal values.

Constraints:
    1 <= word.length <= 1000
    word consists of digits and lowercase English letters.
 */
public class NumberOfDifferentIntegersInAString {

    static class Solution {
        public int numDifferentIntegers(String word) {

            Set<String> numbers = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            boolean isLeadingZero = false;
            for (String letter : word.split("")) {
                if (letter.chars().allMatch(Character::isDigit)) {
                    if (isLeadingZero(letter, stringBuilder)) {
                        isLeadingZero = true;
                    } else {
                        isLeadingZero = false;
                        stringBuilder.append(letter);
                    }
                } else {
                    if (isLeadingZero) {
                        numbers.add("0");
                    } else {
                        addNumber(stringBuilder, numbers);
                        stringBuilder = new StringBuilder();
                    }
                }
            }

            if (isLeadingZero) {
                numbers.add("0");
            } else {
                addNumber(stringBuilder, numbers);
            }

            return numbers.size();
        }

        private static boolean isLeadingZero(String letter, StringBuilder stringBuilder) {
            return letter.equals("0") && stringBuilder.isEmpty();
        }

        private static void addNumber(StringBuilder stringBuilder, Set<String> numbers) {
            if (!stringBuilder.isEmpty()) {
                numbers.add(stringBuilder.toString());
            }
        }
    }
}

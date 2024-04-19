package leetcode;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *      Open brackets must be closed by the same type of brackets.
 *      Open brackets must be closed in the correct order.
 *      Every close bracket has a corresponding open bracket of the same type.
 * Example 1:
 *      Input: s = "()"
 *      Output: true
 * Example 2:
 *      Input: s = "()[]{}"
 *      Output: true
 * Example 3:
 *      Input: s = "(]"
 *      Output: false
 * Constraints:
 *      1 <= s.length <= 104
 *      s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    static class Solution {

        private static final Map<Character, Character> COUNTER_PARTS = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        private static final List<Character> OPENING_PARENTHESES = List.of('(', '{', '[');
        private static final List<Character> CLOSING_PARENTHESES = List.of(')', '}', ']');

        public boolean isValid(String s) {

            Stack<Character> parenthesesStack = new Stack<Character>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (OPENING_PARENTHESES.contains(aChar)) {
                    parenthesesStack.push(aChar);
                } else if (CLOSING_PARENTHESES.contains(aChar)
                        && !isClosingCounterPart(aChar, parenthesesStack)) {
                    return false;
                }
            }

            return parenthesesStack.isEmpty();
        }

        private static boolean isClosingCounterPart(char aChar, Stack<Character> parenthesesStack) {
            return !parenthesesStack.isEmpty() && parenthesesStack.pop() == COUNTER_PARTS.get(aChar);
        }
    }
}

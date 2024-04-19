package leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given a string s of lower and upper case English letters.
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *  0 <= i <= s.length - 2
 *  s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * Notice that an empty string is also good.
 * <p>
 * Example 1:
 *      Input: s = "leEeetcode"
 *      Output: "leetcode"
 *      Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * Example 2:
 *      Input: s = "abBAcC"
 *      Output: ""
 *      Explanation: We have many possible scenarios, and all lead to the same answer. For example:
 *          "abBAcC" --> "aAcC" --> "cC" --> ""
 *          "abBAcC" --> "abBA" --> "aA" --> ""
 * Example 3:
 *      Input: s = "s"
 *      Output: "s"
 * <p>
 * Constraints:
 *      1 <= s.length <= 100
 *      s contains only lower and upper case English letters.
 */
public class MakeTheStringGreat {

    static class Solution {
        public String makeGood(String s) {

            char[] letters = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char letter : letters) {
                if (stack.isEmpty() || !isAlternateCase(letter, stack.peek())) {
                    stack.push(letter);
                } else {
                    stack.pop();
                }
            }
            return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }

        private static boolean isAlternateCase(char letter1, char letter2) {
            return letter1 != letter2 && Character.toUpperCase(letter1) == Character.toUpperCase(letter2);
        }
    }
}

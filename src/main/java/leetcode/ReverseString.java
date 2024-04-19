package leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 *      Input: s = ["h","e","l","l","o"]
 *      Output: ["o","l","l","e","h"]
 * Example 2:
 *      Input: s = ["H","a","n","n","a","h"]
 *      Output: ["h","a","n","n","a","H"]
 * <p>
 * Constraints:
 *      1 <= s.length <= 105
 *      s[i] is a printable ascii character.
 */
public class ReverseString {

    static class Solution {
        public void reverseString(char[] input) {

            for (int i = 0; i < input.length / 2; i++) {

                char temp = input[i];
                int endIndex = input.length - 1 - i;
                input[i] = input[endIndex];
                input[endIndex] = temp;
            }
        }
    }
}

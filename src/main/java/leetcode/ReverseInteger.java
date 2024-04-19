package leetcode;

import java.math.BigInteger;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 *      Input: x = 123
 *      Output: 321
 * Example 2:
 *      Input: x = -123
 *      Output: -321
 * Example 3:
 *      Input: x = 120
 *      Output: 21
 * Constraints:
 *      -231 <= x <= 231 - 1
 */
public class ReverseInteger {

    static class Solution {
        public int reverse(int x) {

            if (x >= 0) {
                return reverseNumber(x);
            } else {
                String number = String.valueOf(x).substring(1);
                return reverseNumber(number) * -1;
            }
        }

        private static Integer reverseNumber(int x) {
            StringBuilder sb = new StringBuilder();
            sb.append(x);
            return reverseAndParseInt(sb);
        }

        private static Integer reverseNumber(String number) {
            StringBuilder sb = new StringBuilder();
            sb.append(number);
            return reverseAndParseInt(sb);
        }

        private static int reverseAndParseInt(StringBuilder sb) {
            sb.reverse();
            long reversed = Long.parseLong(sb.toString());
            if (reversed > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) reversed;
            }
        }
    }
}

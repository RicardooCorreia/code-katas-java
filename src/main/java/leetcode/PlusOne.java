package leetcode;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 *      Input: digits = [1,2,3]
 *      Output: [1,2,4]
 *      Explanation: The array represents the integer 123.
 *      Incrementing by one gives 123 + 1 = 124.
 *      Thus, the result should be [1,2,4].
 * Example 2:
 *      Input: digits = [4,3,2,1]
 *      Output: [4,3,2,2]
 *      Explanation: The array represents the integer 4321.
 *      Incrementing by one gives 4321 + 1 = 4322.
 *      Thus, the result should be [4,3,2,2].
 * Example 3:
 *      Input: digits = [9]
 *      Output: [1,0]
 *      Explanation: The array represents the integer 9.
 *      Incrementing by one gives 9 + 1 = 10.
 *      Thus, the result should be [1,0].
 * <p>
 * Constraints:
 *      1 <= digits.length <= 100
 *      0 <= digits[i] <= 9
 *      digits does not contain any leading 0's.
 */
public class PlusOne {

    static class Solution {
        public int[] plusOne(int[] digits) {

            if (digits[digits.length - 1] < 9) {
                digits[digits.length - 1] = digits[digits.length - 1] + 1;
                return digits;
            } else {
                return getResultWhenLastDigitIsNine(digits);
            }
        }

        private static int[] getResultWhenLastDigitIsNine(int[] digits) {

            int[] result = new int[digits.length + 1]; // might have one more position
            int carry = 1;
            result[result.length - 1] = 0;

            for (int i = digits.length - 2; i >= 0; i--) {
                int current = digits[i];
                int resultIndex = i + 1;

                int currentPlusCarry = current + carry;
                if (currentPlusCarry <= 9) {
                    result[resultIndex] = currentPlusCarry;
                    carry = 0;
                } else {
                    result[resultIndex] = 0;
                    carry = 1;
                }
            }

            if (carry > 0) {
                result[0] = carry;
            } else {
                result = Arrays.copyOfRange(result, 1, result.length);
            }
            return result;
        }
    }
}

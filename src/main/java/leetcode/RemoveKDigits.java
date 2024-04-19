package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * <p>
 * Example 1:
 *      Input: num = "1432219", k = 3
 *      Output: "1219"
 *      Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *      Input: num = "10200", k = 1
 *      Output: "200"
 *      Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *      Input: num = "10", k = 2
 *      Output: "0"
 *      Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * <p>
 * Constraints:
 *      1 <= k <= num.length <= 105
 *      num consists of only digits.
 *      num does not have any leading zeros except for the zero itself.
 */
public class RemoveKDigits {

    static class Solution {

        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for (char digit : num.toCharArray()) {
                while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();

            while (!sb.isEmpty() && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            return !sb.isEmpty() ? sb.toString() : "0";
        }

        public String removeKdigits2(String num, int k) {

            if (num.length() == k) {
                return "0";
            }

            int min = Integer.MAX_VALUE;
            int[] indexes = IntStream.range(0, num.length()).toArray();
            List<List<Integer>> permutations = Permutation.permutations(indexes, k);

            for (List<Integer> permutation : permutations) {

                StringBuilder stringBuilder = new StringBuilder(num);
                permutation.stream()
                        .sorted((o1, o2) -> o2 - o1)
                        .forEach(stringBuilder::deleteCharAt);

                min = Math.min(min, Integer.valueOf(stringBuilder.toString()));
            }
            return Integer.toString(min);
        }

        static class Permutation {

            static void permutations(int[] arr,
                                     int n,
                                     int lengthOfPermutation,
                                     int index,
                                     int[] data,
                                     int i,
                                     List<List<Integer>> permutations) {

                if (index == lengthOfPermutation) {
                    addPermutation(lengthOfPermutation, data, permutations);
                    return;
                }

                if (i >= n)
                    return;

                data[index] = arr[i];
                permutations(arr, n, lengthOfPermutation, index + 1, data, i + 1, permutations);
                permutations(arr, n, lengthOfPermutation, index, data, i + 1, permutations);
            }

            private static void addPermutation(int r, int[] data, List<List<Integer>> permutations) {
                List<Integer> list = new LinkedList<>();
                for (int j = 0; j < r; j++)
                    list.add(data[j]);
                permutations.add(list);
            }

            static List<List<Integer>> permutations(int[] arrayOfData, int lengthOfPermutation) {

                List<List<Integer>> permutations = new LinkedList<>();
                permutations(arrayOfData, arrayOfData.length, lengthOfPermutation, 0, new int[lengthOfPermutation], 0, permutations);
                return permutations;
            }
        }
    }
}

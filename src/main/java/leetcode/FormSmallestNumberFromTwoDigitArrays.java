package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;

/*
Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.

Example 1:
    Input: nums1 = [4,1,3], nums2 = [5,7]
    Output: 15
    Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.
Example 2:
    Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
    Output: 3
    Explanation: The number 3 contains the digit 3 which exists in both arrays.

Constraints:
    1 <= nums1.length, nums2.length <= 9
    1 <= nums1[i], nums2[i] <= 9
    All digits in each array are unique.
 */
public class FormSmallestNumberFromTwoDigitArrays {

    static class Solution {
        public int minNumber(int[] nums1, int[] nums2) {

            Map<Integer, Boolean> sharedNumbers = new HashMap<>();

            final int num1MinValue = Arrays.stream(nums1)
                    .peek(value -> sharedNumbers.putIfAbsent(value, false))
                    .min()
                    .orElse(0);

            final int num2MinValue = Arrays.stream(nums2)
                    .peek(value -> {
                        if (sharedNumbers.containsKey(value)) {
                            sharedNumbers.put(value, true);
                        }
                    })
                    .min()
                    .orElse(0);

            IntSupplier smallestDoubleNumberSupplier = () -> Integer.parseInt(
                    "" +
                            Math.min(num1MinValue, num2MinValue) +
                            Math.max(num1MinValue, num2MinValue)
            );

            return sharedNumbers.entrySet()
                    .stream()
                    .filter(Map.Entry::getValue)
                    .mapToInt(Map.Entry::getKey)
                    .min()
                    .orElseGet(smallestDoubleNumberSupplier);
        }
    }
}

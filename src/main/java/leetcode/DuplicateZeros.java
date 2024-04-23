package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written. Do the above modifications to the input
 array in place and do not return anything.

Example 1:
    Input: arr = [1,0,2,3,0,4,5,0]
    Output: [1,0,0,2,3,0,0,4]
    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:
    Input: arr = [1,2,3]
    Output: [1,2,3]
    Explanation: After calling your function, the input array is modified to: [1,2,3]

Constraints:
    1 <= arr.length <= 104
    0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    static class Solution {

        // Time complexity: O(n^2) Space complexity: O(1)
        public void duplicateZeros(int[] arr) {

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (num == 0) {
                    int previousNumber = 0;
                    for (int j = 1; i + j < arr.length; j++) {
                        int tempPreviousNumber = arr[i + j];
                        arr[i + j] = previousNumber;
                        previousNumber = tempPreviousNumber;
                    }
                    i++;
                }
            }
        }

        // Time complexity: O(n) Space complexity: O(n)
        public void duplicateZerosAlternative(int[] arr) {
            int[] result = IntStream.range(0, arr.length)
                    .flatMap(i -> {
                        int value = arr[i];
                        if (value == 0) {
                            return IntStream.of(0, 0);
                        } else {
                            return IntStream.of(value);
                        }
                    })
                    .limit(arr.length)
                    .toArray();

            System.arraycopy(result, 0, arr, 0, arr.length);
        }
    }
}

package leetcode;

import java.util.*;

/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
    Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
    Output: [15]
    Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:
    Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    Output: [12]
    Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:
    Input: matrix = [[7,8],[1,2]]
    Output: [7]
    Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

Constraints:
    m == mat.length
    n == mat[i].length
    1 <= n, m <= 50
    1 <= matrix[i][j] <= 105.
    All elements in the matrix are distinct.
 */
public class LuckyNumbersInMatrix {

    static class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {

            Map<Integer, Integer> rowMinimum = new HashMap<>();
            Map<Integer, Integer> columnMaximum = new HashMap<>();

            for (int x = 0; x < matrix.length; x++) {
                int[] row = matrix[x];
                for (int y = 0; y < row.length; y++) {
                    int element = row[y];
                    Integer currentMinimum = Optional.ofNullable(rowMinimum.get(x)).orElse(Integer.MAX_VALUE);
                    Integer currentMaximum = Optional.ofNullable(columnMaximum.get(y)).orElse(Integer.MIN_VALUE);
                    if (element < currentMinimum) {
                        rowMinimum.put(x, element);
                    }

                    if (element > currentMaximum) {
                        columnMaximum.put(y, element);
                    }
                }
            }

            Collection<Integer> rowMinimums = rowMinimum.values();
            Collection<Integer> columnMaximums = columnMaximum.values();

            return rowMinimums.stream()
                    .filter(columnMaximums::contains)
                    .toList();
        }
    }
}

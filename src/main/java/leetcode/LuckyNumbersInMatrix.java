package leetcode;

import java.util.*;

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

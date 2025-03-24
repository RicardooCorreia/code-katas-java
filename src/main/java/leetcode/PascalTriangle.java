package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
    Input: numRows = 1
    Output: [[1]]

Constraints:
    1 <= numRows <= 30
 */
public class PascalTriangle {

    static class Solution {
        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> result = new LinkedList<>();
            result.add(List.of(1));
            for (int i = 1; i < numRows; i++) {
                List<Integer> previousRow = result.get(i - 1);
                List<Integer> currentRow = new LinkedList<>();
                currentRow.add(1);
                for (int j = 1; j < i; j++) {
                    currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
                }
                currentRow.add(1);
                result.add(currentRow);
            }
            return result;
        }
    }
}

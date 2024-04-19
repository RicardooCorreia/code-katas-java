package leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *      P   A   H   N
 *      A P L S I I G
 *      Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *      string convert(string s, int numRows);
 * Example 1:
 *      Input: s = "PAYPALISHIRING", numRows = 3
 *      Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *      Input: s = "PAYPALISHIRING", numRows = 4
 *      Output: "PINALSIGYAHRPI"
 *      Explanation:
 *              P     I    N
 *              A   L S  I G
 *              Y A   H R
 *              P     I
 * Example 3:
 *      Input: s = "A", numRows = 1
 *      Output: "A"
 * Constraints:
 *      1 <= s.length <= 1000
 *      s consists of English letters (lower-case and upper-case), ',' and '.'.
 *      1 <= numRows <= 1000
 */
public class ZigzagConversion {

    static class Solution {
        public String convert(String s, int numRows) {

            if (numRows == 1) {
                return s;
            }

            String[][] rows = new String[numRows][s.length()];
            String[] letters = s.split("");

            int x = 0, y = 0;

            if (numRows == 2) {
                noZigZag(s, numRows, letters, x, y, rows);
            } else {
                zigZag(s, numRows, letters, x, y, rows);
            }
            return computeString(rows);
        }

        private static void zigZag(String s, int numRows, String[] letters, int x, int y, String[][] rows) {
            for (int i = 0; i < s.length(); i++) {
                String letter = letters[i];
                boolean fullColumn = x % (numRows - 1) == 0;
                if (fullColumn) {
                    if (y < numRows) {
                        rows[y++][x] = letter;
                    } else {
                        y = numRows - 2;
                        rows[y][++x] = letter;
                    }
                } else {
                    rows[--y][++x] = letter;
                    if (y == 0) {
                        y++;
                    }
                }
            }
        }

        private static void noZigZag(String s, int numRows, String[] letters, int x, int y, String[][] rows) {
            for (int i = 0; i < s.length(); i++) {
                String letter = letters[i];
                if (y < numRows) {
                    rows[y++][x] = letter;
                } else {
                    y = 0;
                    rows[y++][++x] = letter;
                }
            }
        }

        private String computeString(String[][] rows) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows.length; i++) {
                String[] row = rows[i];
                for (int j = 0; j < row.length; j++) {
                    if (row[j] != null) {
                        sb.append(row[j]);
                    }
                }
            }

            return sb.toString();
        }
    }
}

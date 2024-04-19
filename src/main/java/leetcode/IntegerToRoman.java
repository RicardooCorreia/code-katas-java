package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *      Symbol       Value
 *      I             1
 *      V             5
 *      X             10
 *      L             50
 *      C             100
 *      D             500
 *      M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *      I can be placed before V (5) and X (10) to make 4 and 9.
 *      X can be placed before L (50) and C (100) to make 40 and 90.
 *      C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Example 1:
 *      Input: num = 3
 *      Output: "III"
 *      Explanation: 3 is represented as 3 ones.
 * Example 2:
 *      Input: num = 58
 *      Output: "LVIII"
 *      Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 *      Input: num = 1994
 *      Output: "MCMXCIV"
 *      Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Constraints:
 *      1 <= num <= 3999
 */
public class IntegerToRoman {
    static class Solution {

        private static final ArrayList<Map.Entry<Integer, String>> ROMAN_SYMBOLS = new ArrayList<>() {{
            add(Map.entry(1000, "M"));
            add(Map.entry(900, "CM"));
            add(Map.entry(500, "D"));
            add(Map.entry(400, "CD"));
            add(Map.entry(100, "C"));
            add(Map.entry(90, "XC"));
            add(Map.entry(50, "L"));
            add(Map.entry(40, "XL"));
            add(Map.entry(10, "X"));
            add(Map.entry(9, "IX"));
            add(Map.entry(5, "V"));
            add(Map.entry(4, "IV"));
            add(Map.entry(1, "I"));
        }};

        public String intToRoman(int num) {

            int current = num;
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < ROMAN_SYMBOLS.size() && current > 0; i++) {
                Map.Entry<Integer, String> symbol = ROMAN_SYMBOLS.get(i);
                while (current >= symbol.getKey()) {
                    current -= symbol.getKey();
                    stringBuilder.append(symbol.getValue());
                }
            }
            return stringBuilder.toString();
        }
    }
}

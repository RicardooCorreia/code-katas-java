package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
A distinct string is a string that is present only once in an array.
Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
If there are fewer than k distinct strings, return an empty string "".
Note that the strings are considered in the order in which they appear in the array.

Example 1:
    Input: arr = ["d","b","c","b","c","a"], k = 2
    Output: "a"
    Explanation:
    The only distinct strings in arr are "d" and "a".
    "d" appears 1st, so it is the 1st distinct string.
    "a" appears 2nd, so it is the 2nd distinct string.
    Since k == 2, "a" is returned.
Example 2:
    Input: arr = ["aaa","aa","a"], k = 1
    Output: "aaa"
    Explanation:
    All strings in arr are distinct, so the 1st string "aaa" is returned.
Example 3:
    Input: arr = ["a","b","a"], k = 3
    Output: ""
    Explanation:
        The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".

Constraints:
    1 <= k <= arr.length <= 1000
    1 <= arr[i].length <= 5
    arr[i] consists of lowercase English letters.
 */
public class KthDistinctStringInAnArray {

    static class Solution {
        public String kthDistinct(String[] arr, int k) {

            List<String> elements = new LinkedList<>();
            Map<String, Integer> counting = new HashMap<>();
            for (String s : arr) {
                if (counting.containsKey(s)) {
                    elements.remove(s);
                } else {
                    elements.add(s);
                }
                counting.putIfAbsent(s, 0);
                counting.put(s, counting.get(s) + 1);
            }

            return k > elements.size() ? "" : elements.get(k - 1);
        }
    }
}

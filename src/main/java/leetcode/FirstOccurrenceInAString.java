package leetcode;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 *      Input: haystack = "sadbutsad", needle = "sad"
 *      Output: 0
 *      Explanation: "sad" occurs at index 0 and 6.
 *      The first occurrence is at index 0, so we return 0.
 * Example 2:
 *      Input: haystack = "leetcode", needle = "leeto"
 *      Output: -1
 *      Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * Constraints:
 *      1 <= haystack.length, needle.length <= 104
 *      haystack and needle consist of only lowercase English characters.
 */
public class FirstOccurrenceInAString {

    static class Solution {
        public int strStr(String haystack, String needle) {

            char[] haystackCharArray = haystack.toCharArray();
            char[] needleCharArray = needle.toCharArray();

            for (int haystackIndex = 0; haystackIndex < haystackCharArray.length; haystackIndex++) {
                if (haystackCharArray[haystackIndex] == needleCharArray[0]) {
                    if (isNeedle(needleCharArray, haystackCharArray, haystackIndex)) {
                        return haystackIndex;
                    }
                }
            }
            return -1;
        }

        private static boolean isNeedle(char[] needleCharArray, char[] haystackCharArray, int i) {
            for (int needleIndex = 1; needleIndex < needleCharArray.length; needleIndex++) {
                int haystackIndex = i + needleIndex;
                if (haystackIndex >= haystackCharArray.length
                        || haystackCharArray[haystackIndex] != needleCharArray[needleIndex]) {
                    return false;
                }
            }
            return true;
        }
    }
}

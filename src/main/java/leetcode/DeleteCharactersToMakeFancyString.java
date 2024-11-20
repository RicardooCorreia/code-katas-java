package leetcode;

/*
A fancy string is a string where no three consecutive characters are equal.
Given a string s, delete the minimum possible number of characters from s to make it fancy.
Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:
    Input: s = "leeetcode"
    Output: "leetcode"
    Explanation:
        Remove an 'e' from the first group of 'e's to create "leetcode".
        No three consecutive characters are equal, so return "leetcode".
Example 2:
    Input: s = "aaabaaaa"
    Output: "aabaa"
    Explanation:
        Remove an 'a' from the first group of 'a's to create "aabaaaa".
        Remove two 'a's from the second group of 'a's to create "aabaa".
        No three consecutive characters are equal, so return "aabaa".
Example 3:
    Input: s = "aab"
    Output: "aab"
        Explanation: No three consecutive characters are equal, so return "aab".

Constraints:
    1 <= s.length <= 105
    s consists only of lowercase English letters.
 */
public class DeleteCharactersToMakeFancyString {

    static class Solution {
        public String makeFancyString(String s) {

            char previousChar = s.charAt(0);
            int charCount = 1;
            char[] charArray = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder().append(previousChar);
            for (int i = 1; i < charArray.length; i++) {
                char currentChar = charArray[i];
                if (currentChar == previousChar && charCount == 2) {
                    continue;
                } else if (currentChar != previousChar) {
                    charCount = 0;
                }
                stringBuilder.append(currentChar);
                previousChar = currentChar;
                charCount++;
            }
            return stringBuilder.toString();
        }
    }
}

package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given a string s, reverse the string according to the following rules:
    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.
    Return s after reversing it.

Example 1:
    Input: s = "ab-cd"
    Output: "dc-ba"
Example 2:
    Input: s = "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"
Example 3:
    Input: s = "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"

Constraints:
    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.
 */
public class ReverseOnlyLetters {

    static class Solution {
        public String reverseOnlyLetters(String s) {

            Stack<Character> letters = new Stack<>();
            List<Character> nonLetter = new LinkedList<>();

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (Character.isLetter(c)) {
                    letters.push(c);
                } else {
                    nonLetter.add(c);
                }
            }

            for (int i = 0; i < charArray.length; i++) {
                if (Character.isLetter(charArray[i])) {
                    charArray[i] = letters.pop();
                } else {
                    charArray[i] = nonLetter.removeFirst();
                }
            }


            return new String(charArray);
        }
    }
}

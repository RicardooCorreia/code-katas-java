package leetcode;

import java.util.Set;
import java.util.Stack;

public class ReverseVowelsOfString {

    static class Solution {
        
        private static final Set<Character> VOWELS = Set.of(
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
        );
        
        public String reverseVowels(String s) {

            Stack<Character> vowels = new Stack<>();
            
            for (char letter : s.toCharArray()) {
                if (VOWELS.contains(letter)) {
                    vowels.add(letter);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (char letter : s.toCharArray()) {
                if (VOWELS.contains(letter)) {
                    stringBuilder.append(vowels.pop());
                } else {
                    stringBuilder.append(letter);
                }
            }

            return stringBuilder.toString();
        }
    }
}

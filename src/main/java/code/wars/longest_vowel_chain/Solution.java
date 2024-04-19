package code.wars.longest_vowel_chain;

import java.util.List;

class Solution {

    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static int solve(String s) {

        int max = 0;
        int streak = 0;

        for (char letter : s.toCharArray()) {

            if (VOWELS.contains(letter)) {
                streak++;
            } else {
                max = Math.max(max, streak);
                streak = 0;
            }
        }

        return Math.max(max, streak);
    }
}

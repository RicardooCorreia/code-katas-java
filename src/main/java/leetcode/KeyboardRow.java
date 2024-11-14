package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
In the American keyboard:
    the first row consists of the characters "qwertyuiop",
    the second row consists of the characters "asdfghjkl", and
    the third row consists of the characters "zxcvbnm".

Example 1:
    Input: words = ["Hello","Alaska","Dad","Peace"]
    Output: ["Alaska","Dad"]
    Explanation:
        Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.
Example 2:
    Input: words = ["omk"]
    Output: []
Example 3:
    Input: words = ["adsdf","sfd"]
    Output: ["adsdf","sfd"]

Constraints:
    1 <= words.length <= 20
    1 <= words[i].length <= 100
    words[i] consists of English letters (both lowercase and uppercase).
 */
public class KeyboardRow {

    static class Solution {

        private static final Set<Set<Character>> ROWS = Set.of(
                Set.of('q','w','e','r','t','y','u','i','o','p'),
                Set.of('a','s','d','f','g','h','j','k','l'),
                Set.of('z','x','c','v','b','n','m')
        );

        public String[] findWords(String[] words) {

            return Arrays.stream(words)
                    .filter(s -> ROWS.stream()
                            .anyMatch(row -> row.containsAll(getCharList(s))))
                    .toArray(String[]::new);
        }

        private static List<Character> getCharList(String s) {
            LinkedList<Character> characters = new LinkedList<>();
            for (char c : s.toCharArray()) {
                characters.add(Character.toLowerCase(c));
            }
            return characters;
        }
    }
}

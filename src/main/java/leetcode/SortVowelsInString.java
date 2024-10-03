package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortVowelsInString {

    static class Solution {

        private static final Set<String> VOWELS = Set.of("A", "E", "I", "O", "U", "a", "e", "i", "o", "u");

        public String sortVowels(String s) {

            String[] letters = s.split("");
            List<String> sortedVowels = new LinkedList<>(Arrays.stream(letters)
                    .filter(this::isVowel)
                    .sorted()
                    .toList());

            return Arrays.stream(letters)
                    .map(letter -> {
                        if (isVowel(letter)) {
                            return sortedVowels.remove(0);
                        } else {
                            return letter;
                        }
                    })
                    .collect(Collectors.joining());
        }

        private boolean isVowel(String letter) {
            return VOWELS.contains(letter);
        }
    }
}

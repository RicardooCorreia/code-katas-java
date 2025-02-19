package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UncommonWordsFromTwoSentences {

    static class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {

            String combined = s1 + " " + s2;
            Set<String> uniqueWords = new HashSet<>();
            Set<String> repeatedWords = new HashSet<>();

            for (String word : combined.split(" ")) {
                if (!uniqueWords.add(word) || repeatedWords.contains(word)) {
                    uniqueWords.remove(word);
                    repeatedWords.add(word);
                }
            }

            return uniqueWords.toArray(new String[0]);
        }
    }
}

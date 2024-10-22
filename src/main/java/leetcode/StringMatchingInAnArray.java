package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatchingInAnArray {

    static class Solution {

        public List<String> stringMatching(String[] words) {

            List<String> returnList = new ArrayList<>();
            for (String word : words) {
                boolean isSubString = Arrays.stream(words)
                        .filter(s -> !s.equals(word))
                        .anyMatch(s -> s.contains(word));
                if (isSubString) returnList.add(word);
            }
            return returnList;
        }
    }
}

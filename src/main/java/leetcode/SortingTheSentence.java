package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 Each word consists of lowercase and uppercase English letters.
A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

Example 1:
    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
Example 2:
    Input: s = "Myself2 Me1 I4 and3"
    Output: "Me Myself and I"
    Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.

Constraints:
    2 <= s.length <= 200
    s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
    The number of words in s is between 1 and 9.
    The words in s are separated by a single space.
    s contains no leading or trailing spaces.
 */
public class SortingTheSentence {

    static class Solution {

        private static final String REGEX = "(?<word>\\D+)(?<number>\\d+)";

        public String sortSentence(String s) {

            Pattern pattern = Pattern.compile(REGEX);
            return Arrays.stream(s.split(" "))
                    .map(word -> extractWordAndNumber(word, pattern))
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(" "));
        }

        private static Map.Entry<String, Integer> extractWordAndNumber(String word, Pattern pattern) {
            Matcher matcher = pattern.matcher(word);
            matcher.find();
            String parsedWord = matcher.group("word");
            int number = Integer.parseInt(matcher.group("number"));
            return Map.entry(parsedWord, number);
        }
    }
}

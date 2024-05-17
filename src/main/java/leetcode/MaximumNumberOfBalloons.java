package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
    Input: text = "nlaebolko"
    Output: 1
Example 2:
    Input: text = "loonbalxballpoon"
    Output: 2
Example 3:
    Input: text = "leetcode"
    Output: 0

Constraints:
    1 <= text.length <= 104
    text consists of lower case English letters only.
 */
public class MaximumNumberOfBalloons {

    static class Solution {

        private final Map<Character, Integer> requiredLetters = Map.of(
                'b', 1,
                'a', 1,
                'l', 2,
                'o', 2,
                'n', 1
        );

        public int maxNumberOfBalloons(String text) {

            Map<Character, Long> amountOfLetters = text.chars()
                    .mapToObj(value -> (char) value)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            return requiredLetters.entrySet()
                    .stream()
                    .mapToInt(entry -> {
                        Long letterCount = amountOfLetters.get(entry.getKey());
                        if (letterCount == null) {
                            return 0;
                        }
                        return Math.toIntExact(letterCount / entry.getValue());
                    })
                    .min()
                    .getAsInt();
        }
    }
}

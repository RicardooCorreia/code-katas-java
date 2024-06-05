package leetcode;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
 You may return the answer in any order.

Example 1:
    Input: words = ["bella","label","roller"]
    Output: ["e","l","l"]
Example 2:
    Input: words = ["cool","lock","cook"]
    Output: ["c","o"]

Constraints:
    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists of lowercase English letters.
 */
public class FindCommonCharacters {

    static class Solution {
        public List<String> commonChars(String[] words) {


            return Arrays.stream(words)
                    .map(word -> Arrays.stream(word.split(""))
                            .collect(Collectors.groupingBy(letter -> letter, Collectors.counting())))
                    .reduce(new HashMap<>(), aggregateCountsByLetter(), mergeMaps())
                    .entrySet()
                    .stream()
                    .filter(stringListEntry -> stringListEntry.getValue().size() == words.length)
                    .map(counts -> Map.entry(
                            counts.getKey(),
                            counts.getValue().stream().min(Comparator.comparingInt(o -> o)).orElse(0)))
                    .flatMap(letterCount ->
                            IntStream.rangeClosed(1, letterCount.getValue()).mapToObj(i -> letterCount.getKey()))
                    .toList();
        }

        private static BiFunction<HashMap<String, List<Integer>>, Map<String, Long>, HashMap<String, List<Integer>>> aggregateCountsByLetter() {
            return (result, map) -> {
                map.forEach((letter, count) -> {
                    result.putIfAbsent(letter, new LinkedList<>());
                    result.get(letter).add(Math.toIntExact(count));
                });
                return result;
            };
        }

        private static BinaryOperator<HashMap<String, List<Integer>>> mergeMaps() {
            return (result1, result2) -> {
                result2.forEach((letter, counts) -> {
                    result1.putIfAbsent(letter, new LinkedList<>());
                    result1.get(letter).addAll(counts);
                });
                return result1;
            };
        }
    }
}

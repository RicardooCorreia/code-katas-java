package code.wars.highest_scoring_word;

import java.util.Arrays;
import java.util.Comparator;

public class Kata {

    public static String high(String sentence) {

        return Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(Kata::countPoints))
                .orElse(null);
    }

    private static Integer countPoints(String word) {

        return word.chars()
                .map(c -> c - 96)
                .sum();
    }
}

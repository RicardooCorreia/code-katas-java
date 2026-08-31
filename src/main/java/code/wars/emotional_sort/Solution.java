package code.wars.emotional_sort;

import java.util.Map;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparing;

public class Solution {

    private static final Map<String, Integer> emotionalValues = Map.of(
        ":D", 2,
        ":)", 1,
        ":|", 0,
        ":(", -1,
        "T_T", -2
    );

    public static String[] sortEmotions(boolean order, String[] emotions) {
        sort(emotions, order ? comparing(emotionalValues::get).reversed() : comparing(emotionalValues::get));
        return emotions;
    }
}

package code.wars.greed_is_good;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Greed {

    public static int greedy(int[] dice) {

        return Arrays.stream(dice)
                .boxed()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .mapToInt(entry -> {
                    Integer number = entry.getKey();
                    Long count = entry.getValue();
                    int score = 0;
                    int multiScore = getMultiScore(number);
                    while (count >= 3) {
                        score += multiScore;
                        count -= 3;
                    }
                    if (count > 0 && numberScoresSingle(number)) {
                        int singleScore = multiScore / 10;
                        score += count * singleScore;
                    }
                    return score;
                })
                .sum();
    }

    private static boolean numberScoresSingle(Integer number) {

        return number == 1 || number == 5;
    }

    private static int getMultiScore(Integer number) {

        if (number > 1 && number < 7) {
            return number * 100;
        } else {
            return 1000;
        }
    }
}


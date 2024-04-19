package code.wars.good_vs_evil;

import java.util.List;
import java.util.stream.IntStream;

public class GoodVsEvil {

    public static final String TIE_RESULT = "Battle Result: No victor on this battle field";
    public static final String GOOD_RESULT = "Battle Result: Good triumphs over Evil";
    public static final String EVIL_RESULT = "Battle Result: Evil eradicates all trace of Good";

    private static final List<Integer> goodWorth = List.of(1, 2, 3, 3, 4, 10);
    private static final List<Integer> evilWorth = List.of(1, 2, 2, 2, 3, 5, 10);

    public static String battle(String goodAmounts, String evilAmounts) {

        final int goodCount = calculateValue(goodAmounts, goodWorth);
        final int evilCount = calculateValue(evilAmounts, evilWorth);

        if (goodCount == evilCount) {
            return TIE_RESULT;
        } else {
            return goodCount > evilCount ? GOOD_RESULT : EVIL_RESULT;
        }
    }

    private static int calculateValue(String amounts, List<Integer> worth) {

        final String[] counts = amounts.split(" ");
        return IntStream.range(0, counts.length)
                .mapToObj(i -> Integer.parseInt(counts[i]) * worth.get(i))
                .reduce(0, Integer::sum);
    }
}

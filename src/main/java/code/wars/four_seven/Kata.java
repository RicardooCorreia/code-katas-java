package code.wars.four_seven;

import java.util.Map;

public class Kata {

    private static final Map<Integer, Integer> MAPPING = Map.of(
            4, 7,
            7, 4);

    public static int fourSeven(int n) {

        return MAPPING.getOrDefault(n, 0);
    }
}

package code.wars.bingo_or_not;

import java.util.Arrays;
import java.util.List;

public class BingoOrNot {

    private static final List<Integer> BINGO_LETTERS = List.of(2, 9, 14, 7, 15);

    public static String bingo(int[] numberArray) {

        return Arrays.stream(numberArray).boxed().toList()
                .containsAll(BINGO_LETTERS) ? "WIN" : "LOSE";
    }
}

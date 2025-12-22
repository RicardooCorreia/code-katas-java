package code.wars.square_sum;

import java.util.Arrays;

public class Kata {
    public static int squareSum(int[] n) {

        return Arrays.stream(n)
                .map(operand -> operand * operand)
                .sum();
    }
}

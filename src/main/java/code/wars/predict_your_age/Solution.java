package code.wars.predict_your_age;

import java.util.Arrays;

public class Solution {
    public static int predictAge(int... ages) {

        final int sum = Arrays.stream(ages)
                .map(operand -> operand * operand)
                .sum();

        final double squareRoot = Math.sqrt(sum);

        return (int) (squareRoot / 2);
    }
}

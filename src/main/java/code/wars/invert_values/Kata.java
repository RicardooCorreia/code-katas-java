package code.wars.invert_values;

import java.util.Arrays;

public class Kata {
    public static int[] invert(int[] array) {

        return Arrays.stream(array)
                .map(operand -> operand * -1)
                .toArray();
    }
}

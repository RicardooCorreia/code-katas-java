package code.wars.between_extremes;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Kata {
    public static int betweenExtremes(int[] numbers) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }


        return max - min;
    }
}

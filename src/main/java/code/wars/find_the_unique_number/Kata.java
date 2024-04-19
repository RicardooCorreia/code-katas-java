package code.wars.find_the_unique_number;

import java.util.Arrays;

public class Kata {
    public static double findUniq(double arr[]) {

        final double first = arr[0];
        final double second = arr[1];
        if (first == second) {
            return Arrays.stream(arr)
                    .filter(n -> n != first)
                    .findAny()
                    .orElse(0);
        } else {
            final double third = arr[2];
            return first == third ? second : first;
        }
    }
}

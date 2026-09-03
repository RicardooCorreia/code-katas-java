package code.wars.equal_side_of_an_array;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class Kata {
    public static int findEvenIndex(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            final var left = Arrays.copyOfRange(arr, 0, i);
            final var right = Arrays.copyOfRange(arr, i + 1, arr.length);
            if (sum(left) == sum(right)) {
                return i;
            }
        }
        return -1;
    }

    private static long sum(int[] array) {
        return stream(array).sum();
    }
}

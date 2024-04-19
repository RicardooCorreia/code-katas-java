package code.wars.sum_of_differences_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZywOo {
    public static int sumOfDifferences(int[] arr) {

        Arrays.sort(arr);
        final List<Integer> numbersToSum = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {

            numbersToSum.add(arr[i] - arr[i - 1]);
        }
        return numbersToSum.stream()
                .mapToInt(value -> value)
                .sum();
    }
}

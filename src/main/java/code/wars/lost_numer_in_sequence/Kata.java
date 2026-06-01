package code.wars.lost_numer_in_sequence;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Kata {

    public static int findDeletedNumber(int[] arr, int[] mixedArr) {

        final var numbers = stream(mixedArr)
            .boxed()
            .collect(Collectors.toSet());

        for (var num : arr) {
            if (!numbers.contains(num)) {
                return num;
            }
        }
        return 0;
    }
}

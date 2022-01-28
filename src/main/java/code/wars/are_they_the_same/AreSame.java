package code.wars.are_they_the_same;

import java.util.Arrays;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {

        final boolean isValid = a != null && b != null && a.length != 0 && b.length != 0;
        if (!isValid) {
            return false;
        }

        final int[] multipliedAndSorted = Arrays.stream(a)
                .map(number -> number * number)
                .sorted()
                .toArray();
        Arrays.sort(b);
        return Arrays.equals(multipliedAndSorted, b);
    }
}

package code.wars.largest_elements;

import static java.util.Arrays.stream;

public class Solution {

    public static int[] largest(int n, int[] arr) {

        return stream(arr)
            .sorted()
            .skip(arr.length - n)
            .toArray();
    }
}

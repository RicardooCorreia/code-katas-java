package code.wars.maximum_length_difference;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class MaxDiffLength {

    public static int mxdiflg(String[] a1, String[] a2) {

        if (a1.length == 0 || a2.length == 0) {
            return -1;
        }

        final MaxAndMin result1 = findMaxAndMin(a1);
        final MaxAndMin result2 = findMaxAndMin(a2);

        return max(abs(result1.max - result2.min), abs(result2.max - result1.min));
    }

    private static MaxAndMin findMaxAndMin(String[] a1) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String string : a1) {
            final int length = string.length();
            if (length > max) {
                max = length;
            }
            if (length < min) {
                min = length;
            }
        }
        MaxAndMin result = new MaxAndMin(max, min);
        return result;
    }

    private record MaxAndMin(int max, int min) {

    }
}

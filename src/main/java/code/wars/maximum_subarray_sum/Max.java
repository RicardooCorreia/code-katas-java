package code.wars.maximum_subarray_sum;

public class Max {

    public static int sequence(int[] arr) {

        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int value : arr) {
            maxEndingHere = Math.max(0, maxEndingHere + value);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

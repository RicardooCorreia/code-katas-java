package code.wars.sum_of_parts;

public class SumParts {

    public static int[] sumParts(int[] ls) {

        int[] result = new int[ls.length + 1];
        int runningSum = 0;
        result[ls.length] = runningSum;
        for (var i = ls.length - 1; i >= 0; i--) {
            final var currentSum = runningSum + ls[i];
            result[i] = currentSum;
            runningSum = currentSum;
        }
        return result;
    }
}

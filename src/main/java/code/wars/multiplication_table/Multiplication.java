package code.wars.multiplication_table;

import java.util.stream.IntStream;

public class Multiplication {

    public static int[][] multiplicationTable(int n) {

        if (n < 0) {
            return null;
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int numberToFill = i + 1;
            result[i][0] = numberToFill;
            result[0][i] = numberToFill;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[0][j] * result[i][0];
            }
        }

        return result;
    }

    public static int[][] multiplicationTableAlternative(int n) {

        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> IntStream.rangeClosed(1, n)
                        .map(j -> i * j)
                        .toArray())
                .toArray(value -> new int[n][n]);
    }
}

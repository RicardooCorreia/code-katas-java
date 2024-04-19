package haker.rank.utopian_tree;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int utopianTree(int n) {
        // Write your code here

        final int initialHeight = 1;
        if (n == 0) {
            return initialHeight;
        }

        return cycleOfLife(initialHeight, n, SpringSeason.INSTANCE);
    }

    private interface Season {

        Season getNextSeason();

        int growTree(int height);
    }

    private static class SpringSeason implements Season {

        public static final SpringSeason INSTANCE = new SpringSeason();

        @Override
        public Season getNextSeason() {
            return SummerSeason.INSTANCE;
        }

        @Override
        public int growTree(int height) {

            return height * 2;
        }
    }

    private static class SummerSeason implements Season {

        public static final SummerSeason INSTANCE = new SummerSeason();

        @Override
        public Season getNextSeason() {

            return SpringSeason.INSTANCE;
        }

        @Override
        public int growTree(int height) {

            return height + 1;
        }
    }

    private static int cycleOfLife(int height,
                                   int iteration,
                                   Season season) {

        final int newHeight = season.growTree(height);
        final int newIteration = iteration - 1;
        if (newIteration > 0) {
            return cycleOfLife(newHeight, newIteration, season.getNextSeason());
        } else {
            return newHeight;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.utopianTree(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


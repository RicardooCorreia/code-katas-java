package haker.rank.funny_string;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    public static final String FUNNY = "Funny";
    public static final String NOT_FUNNY = "Not Funny";

    public static String funnyString(String string) {

        final char[] chars = string.toCharArray();
        final char[] reversedChars = new StringBuilder(string).reverse().toString().toCharArray();
        final int length = string.length();
        for (int i = 0; i < length - 1; i++) {
            boolean adjacentEqual = compareAdjacent(chars, reversedChars, i);
            if (!adjacentEqual) return NOT_FUNNY;
        }

        return FUNNY;
    }

    private static boolean compareAdjacent(char[] chars, char[] reversedChars, int i) {

        final int adjacent = chars[i] - chars[i + 1];
        final int reversedAdjacent = reversedChars[i] - reversedChars[i + 1];
        return Math.abs(adjacent) == Math.abs(reversedAdjacent);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


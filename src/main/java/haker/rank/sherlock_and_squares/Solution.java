package haker.rank.sherlock_and_squares;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {

        final int firstSquare = findFirstSquare(a, b);
        return firstSquare != -1 ? countSquares(b, firstSquare) : 0;
    }

    /**
     * Goes over every number, to get the first one that is a square
     * @param a beginLimit
     * @param b endLimit
     * @return first number that is root, or -1 if it doesn't exist
     */
    private static int findFirstSquare(int a, int b) {

        for (int i = a; i <= b; i++) {
            final double sqrt = Math.sqrt(i);
            if (sqrt == (int) sqrt) {

                return i;
            }
        }
        return -1;
    }

    /**
     * Count squares from `i` to `endLimit`, assuming that `i` is already a root
     *
     * This method follows a pattern to skip most of the numbers.
     * The pattern is:
     * 1 = sqrt(1)
     * 4 = sqrt(2)
     * 9 = sqrt(3)
     * 16 = sqrt(4)
     * 25 = sqrt(5)
     *
     * We can see that from 1 - 4 = 3, 4 - 9 = 5, 9 - 16 = 7, 16 - 25 = 9.
     * We can also conclude that 2 x squareRoot + 1 = `nextInSequence`. Example 1 x 2 + 1 = 3, 2 * 2 + 1 = 5, 3 * 2 + 1 = 7.
     *
     * Sequence (seq) is                [   3,   5,   7,    9 ,   11,    13    ]
     * Squares (squares) are            [   1,   4,   9,    16 ,  25,   36     ]
     * Roots of those squares (root)    [   1,   2,   3,    4 ,    5,    6     ]
     *
     * From there we can assume that the next square will only happen for currentSquare + nextInSequence.
     * Examples:
     *
     * 1)
     * CurrentSquare = 1
     * root = 1
     *
     * Then: root * 2 + 1 = seq <=> 1 * 2 + 1 = 3
     * Then: currentSquare + seq = nextSquare <=> 1 + 3 = 4
     *
     * 2)
     * CurrentSquare = 16
     * root = 4
     *
     * Then: root * 2 + 1 = seq <=> 4 * 2 + 1 = 9
     * Then: currentSquare + seq = nextSquare <=> 16 + 9 = 25
     *
     * @param endLimit limit to check for squares
     * @param i beginning to check for squares, assuming that it is already squared
     * @return count of squares from `i` to `endLimit`.
     */
    private static int countSquares(int endLimit, int i) {

        int count = 0;
        double nextSquare;
        double currentSquare = i;

        do {
            count++;
            final double squareRoot = Math.sqrt(currentSquare);
            double nextInSequence = squareRoot * 2 + 1;
            nextSquare = currentSquare + nextInSequence;
            currentSquare = nextSquare;

        } while (nextSquare <= endLimit);

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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

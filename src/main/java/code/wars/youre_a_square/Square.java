package code.wars.youre_a_square;

public class Square {

    public static boolean isSquare(int n) {

        final double squareRoot = Math.sqrt(n);
        return squareRoot == (int) squareRoot;
    }
}

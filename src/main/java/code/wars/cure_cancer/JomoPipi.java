package code.wars.cure_cancer;

public class JomoPipi {

    public static int[] mutationLocation(char[][] body) {

        for (int row = 1; row < body.length - 1; row++) {
            final char[] letters = body[row];

            for (int letter = 0; letter < letters.length; letter++) {

                char middleLetter = letters[letter];
                char letterAbove = body[row - 1][letter];
                char letterBelow = body[row + 1][letter];

                if (middleLetter != letterAbove || middleLetter != letterBelow) {
                    return findCancer(row, letter, middleLetter, letterAbove, letterBelow);
                }
            }
        }

        return new int[0];
    }

    private static int[] findCancer(int i, int j, char middleLetter, char letterAbove, char letterBelow) {

        if (middleLetter == letterAbove) {
            // letter below
            return new int[]{i + 1, j};
        } else if (middleLetter == letterBelow) {
            // letter above
            return new int[]{i - 1, j};
        } else {
            // middle letter
            return new int[]{i, j};
        }
    }
}

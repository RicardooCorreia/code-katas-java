package code.wars.scrabble_score;

public class Kata {
    public static int scrabbleScore(String word) {

        return word.chars()
                .mapToObj(i -> (char) i)
                .mapToInt(Kata::getLetterValue)
                .sum();
    }

    private static int getLetterValue(char letter) {

        final char upperCase = Character.toUpperCase(letter);
        return switch (upperCase) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }
}

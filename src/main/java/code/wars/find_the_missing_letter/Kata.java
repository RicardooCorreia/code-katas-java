package code.wars.find_the_missing_letter;

public class Kata {
    public static char findMissingLetter(char[] array) {

        char expectedLetter = array[0];
        for (char letter : array) {
            if (expectedLetter == letter) {
                expectedLetter++;
            } else {
                break;
            }
        }
        return expectedLetter;
    }
}

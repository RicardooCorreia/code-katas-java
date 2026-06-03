package code.wars.wheres_wally;

import java.util.List;

import static java.lang.Character.isLetterOrDigit;

public class WallyFinder {

    private static final List<Character> WALLY_LETTERS = List.of('W', 'a', 'l', 'l', 'y');

    public static int wheresWally(String str) {

        if (str.isBlank()) {
            return -1;
        }

        final char[] charArray = str.toCharArray();
        char previousChar = charArray[0];
        boolean runningWally = previousChar == 'W';
        int wallyStart = runningWally ? 0 : -1;

        for (int i = 1; i < charArray.length; i++) {
            final char currentChar = charArray[i];
            if (isWallyStart(currentChar, previousChar)) {
                runningWally = true;
                wallyStart = i;
            } else if (runningWally) {
                if (wallyWordIsFinished(i, wallyStart)) {
                    if (!isLetterOrDigit(currentChar)) {
                        return wallyStart;
                    } else {
                        runningWally = false;
                        wallyStart = -1;
                    }
                } else if (!isCorrectNextCharInWallyWord(currentChar, i, wallyStart)) {
                    runningWally = false;
                    wallyStart = -1;
                }
            }
            previousChar = currentChar;
        }

        return wallyStart;
    }

    private static boolean isCorrectNextCharInWallyWord(char currentChar, int i, int wallyStart) {
        return currentChar == WALLY_LETTERS.get(i - wallyStart);
    }

    private static boolean wallyWordIsFinished(int i, int wallyStart) {
        return i - wallyStart >= WALLY_LETTERS.size();
    }

    private static boolean isWallyStart(char currentChar, char previousChar) {
        return currentChar == 'W' && previousChar == ' ';
    }
}

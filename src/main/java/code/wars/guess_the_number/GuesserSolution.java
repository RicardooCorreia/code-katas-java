package code.wars.guess_the_number;

public class GuesserSolution extends Guesser {

    public int getNumber() {

        return guessTheNumber(500, 0, 1000, 0);
    }

    private int guessTheNumber(int guess, int lowerLimit, int upperLimit, int guessCount) {

        final String result = guess(guess);
        if (CORRECT.equals(result)) {
            return guess;
        } else if (TOO_HIGH.equals(result)) {
            return guessCount == 9 ?
                    guess - 1 :
                    guessTheNumber((guess + lowerLimit) / 2, lowerLimit, guess, guessCount + 1);
        } else {
            return guessCount == 9 ?
                    guess + 1 :
                    guessTheNumber((guess + upperLimit) / 2, guess, upperLimit, guessCount + 1);
        }
    }
}

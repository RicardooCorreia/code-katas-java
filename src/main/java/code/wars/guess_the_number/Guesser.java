package code.wars.guess_the_number;

public abstract class Guesser {

    public static final String CORRECT = "Correct!";
    public static final String TOO_HIGH = "Too high!";
    public static final String TOO_LOW = "Too low!";

    private int answer;

    private int count = 0;

    protected final String guess(int i) {

        if (++count > 10) {
            throw new RuntimeException("Too many attempts");
        }

        if (i == answer) {
            return CORRECT;
        } else if (i > answer) {
            return TOO_HIGH;
        } else {
            return TOO_LOW;
        }
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}

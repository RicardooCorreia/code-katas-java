package code.wars.monty_hall_problem;

import java.util.Arrays;

public class MontyHall {

    public int montyHallCase(int correctDoorNumber, int[] participantGuesses) {

        final int correctCount = (int) Arrays.stream(participantGuesses, 0, participantGuesses.length)
                .filter(operand -> operand != correctDoorNumber)
                .count();
        return (int) Math.round(((double) correctCount / participantGuesses.length) * 100);
    }
}

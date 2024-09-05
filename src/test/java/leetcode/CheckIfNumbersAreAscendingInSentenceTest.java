package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfNumbersAreAscendingInSentenceTest {

    private final CheckIfNumbersAreAscendingInSentence.Solution subject
            = new CheckIfNumbersAreAscendingInSentence.Solution();

    @Test
    void areNumbersAscending_whenAreAscending_returnTrue() {

        // Given
        String input = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";

        // When
        boolean result = subject.areNumbersAscending(input);

        // Then
        assertTrue(result);
    }

    @Test
    void areNumbersAscending_whenAreSameNumber_returnFalse() {

        // Given
        String input = "hello world 5 x 5";

        // When
        boolean result = subject.areNumbersAscending(input);

        // Then
        assertFalse(result);
    }

    @Test
    void areNumbersAscending_whenAreNotAscending_returnFalse() {

        // Given
        String input = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";

        // When
        boolean result = subject.areNumbersAscending(input);

        // Then
        assertFalse(result);
    }
}
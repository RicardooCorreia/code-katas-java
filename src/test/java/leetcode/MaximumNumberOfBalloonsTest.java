package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfBalloonsTest {

    private final MaximumNumberOfBalloons.Solution subject = new MaximumNumberOfBalloons.Solution();

    @Test
    void maxNumberOfBalloons_whenBalloonIsPossible_returnMaxNumberOfBalloons() {

        // Given
        String input = "nlaebolko";

        // When
        int result = subject.maxNumberOfBalloons(input);

        // Then
        assertEquals(1, result);
    }

    @Test
    void maxNumberOfBalloons_when22BalloonsArePossible_returnMaxNumberOfBalloons() {

        // Given
        String input = "loonbalxballpoon";

        // When
        int result = subject.maxNumberOfBalloons(input);

        // Then
        assertEquals(2, result);
    }

    @Test
    void maxNumberOfBalloons_whenBalloonIsNotPossible_returnZero() {

        // Given
        String input = "leetcode";

        // When
        int result = subject.maxNumberOfBalloons(input);

        // Then
        assertEquals(0, result);
    }
}
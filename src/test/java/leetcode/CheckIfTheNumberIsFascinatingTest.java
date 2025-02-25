package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckIfTheNumberIsFascinatingTest {

    private final CheckIfTheNumberIsFascinating.Solution subject = new CheckIfTheNumberIsFascinating.Solution();

    @Test
    void isFascinating_whenMultiplicationHasEveryNumber_returnTrue() {

        // Given
        int input = 192;

        // When
        boolean result = subject.isFascinating(input);

        // Then
        assertTrue(result);
    }

    @Test
    void isFascinating_whenMultiplicationDoesNotHaveEveryNumber_returnFalse() {

        // Given
        int input = 100;

        // When
        boolean result = subject.isFascinating(input);

        // Then
        assertFalse(result);
    }
}
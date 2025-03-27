package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotReturnToOriginTest {

    private final RobotReturnToOrigin.Solution subject = new RobotReturnToOrigin.Solution();

    @Test
    void judgeCircle_whenReturnsToOrigin_returnTrue() {

        // Given
        String input = "UD";

        // When
        boolean result = subject.judgeCircle(input);

        // Then
        assertTrue(result);
    }

    @Test
    void judgeCircle_whenDoesNotReturnsToOrigin_returnFalse() {

        // Given
        String input = "LL";

        // When
        boolean result = subject.judgeCircle(input);

        // Then
        assertFalse(result);
    }
}
package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeConsecutiveOddsTest {

    private final ThreeConsecutiveOdds.Solution subject = new ThreeConsecutiveOdds.Solution();

    @Test
    void threeConsecutiveOdds_whenHasConsecutiveOdds_returnTrue() {

        // Given
        int[] input = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        // When
        boolean result = subject.threeConsecutiveOdds(input);

        // Then
        assertTrue(result);
    }

    @Test
    void threeConsecutiveOdds_whenDoesNotHaveConsecutive_returnFalse() {

        // Given
        int[] input = {2, 6, 4, 1};

        // When
        boolean result = subject.threeConsecutiveOdds(input);

        // Then
        assertFalse(result);
    }
}
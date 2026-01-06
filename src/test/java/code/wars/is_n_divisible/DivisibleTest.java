package code.wars.is_n_divisible;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivisibleTest {

    @Test
    void isDivisible_whenIsDivisible_returnTrue() {

        // Given
        int[] input = {12, 3, 4, 6};

        // When
        boolean result = Divisible.isDivisible(input);

        // Then
        assertTrue(result);
    }

    @Test
    void isDivisible_whenIsNotDivisible_returnFalse() {

        // Given
        int[] input = {8, 3, 4, 2, 5};

        // When
        boolean result = Divisible.isDivisible(input);

        // Then
        assertFalse(result);
    }
}

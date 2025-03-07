package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckBalancedStringTest {

    private final CheckBalancedString.Solution subject = new CheckBalancedString.Solution();

    @Test
    void isBalanced_whenIsNotBalanced_returnFalse() {

        // Given
        String input = "1234";

        // When
        boolean result = subject.isBalanced(input);

        // Then
        assertFalse(result);
    }

    @Test
    void isBalanced_whenIsBalanced_returnTrue() {

        // Given
        String input = "24123";

        // When
        boolean result = subject.isBalanced(input);

        // Then
        assertTrue(result);
    }
}
package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    private final PalindromeNumber.Solution subject = new PalindromeNumber.Solution();

    @Test
    void isPalindrome_whenTrue_returnsTrue() {

        // Given
        int input = 121;

        // When
        boolean result = subject.isPalindrome(input);

        // Then
        assertTrue(result);
    }

    @Test
    void isPalindrome_whenNegative_returnsFalse() {

        // Given
        int input = -121;

        // When
        boolean result = subject.isPalindrome(input);

        // Then
        assertFalse(result);
    }

    @Test
    void isPalindrome_whenFalse_returnsFalse() {

        // Given
        int input = 10;

        // When
        boolean result = subject.isPalindrome(input);

        // Then
        assertFalse(result);
    }
}
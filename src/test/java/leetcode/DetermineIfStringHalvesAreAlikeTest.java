package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetermineIfStringHalvesAreAlikeTest {

    private final DetermineIfStringHalvesAreAlike.Solution subject = new DetermineIfStringHalvesAreAlike.Solution();

    @Test
    void halvesAreAlike_whenAlike_returnTrue() {

        // Given
        String input = "book";

        // When
        boolean result = subject.halvesAreAlike(input);

        // Then
        assertTrue(result);
    }


    @Test
    void halvesAreAlike_whenNotAlike_returnFalse() {

        // Given
        String input = "textbook";

        // When
        boolean result = subject.halvesAreAlike(input);

        // Then
        assertFalse(result);
    }
}
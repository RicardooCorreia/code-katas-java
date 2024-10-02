package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectCapitalTest {

    private final DetectCapital.Solution subject = new DetectCapital.Solution();

    @ParameterizedTest
    @ValueSource(strings = {"USA", "leetcode", "Google"})
    void detectCapitalUse_whenCorrect_returnTrue(
            // Given
            String word) {

        // When
        boolean result = subject.detectCapitalUse(word);

        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"iuaA", "FlaG", "FSJFSs"})
    void detectCapitalUse_whenNotCorrect_returnFalse(
            // Given
            String word) {

        // When
        boolean result = subject.detectCapitalUse(word);

        // Then
        assertFalse(result);
    }
}
package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfTheSentenceIsPangramTest {

    private final CheckIfTheSentenceIsPangram.Solution subject = new CheckIfTheSentenceIsPangram.Solution();

    @Test
    void checkIfPangram_whenHasAllLetters_returnTrue() {

        // Given
        String input = "thequickbrownfoxjumpsoverthelazydog";

        // When
        boolean result = subject.checkIfPangram(input);

        // Then
        assertTrue(result);
    }

    @Test
    void checkIfPangram_whenDoesNotHaveAllLetters_returnFalse() {

        // Given
        String input = "leetcode";

        // When
        boolean result = subject.checkIfPangram(input);

        // Then
        assertFalse(result);
    }
}
package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RansomNoteTest {

    private final RansomNote.Solution subject = new RansomNote.Solution();

    @Test
    void canConstruct_whenContainsAllLetters_returnTrue() {

        // Given
        String ransomNote = "aa";
        String magazine = "aab";

        // When
        boolean result = subject.canConstruct(ransomNote, magazine);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void canConstruct_whenDoesContainsLettersButDontHaveEnough_returnFalse() {

        // Given
        String ransomNote = "aa";
        String magazine = "ab";

        // When
        boolean result = subject.canConstruct(ransomNote, magazine);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void canConstruct_whenDoesNotContainsAllLetters_returnFalse() {

        // Given
        String ransomNote = "aa";
        String magazine = "b";

        // When
        boolean result = subject.canConstruct(ransomNote, magazine);

        // Then
        assertThat(result)
                .isFalse();
    }
}
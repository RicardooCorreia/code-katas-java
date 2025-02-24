package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordPatternTest {

    private final WordPattern.Solution subject = new WordPattern.Solution();

    @Test
    void wordPattern_whenCanReplace_returnTrue() {

        // Given
        String sentence = "dog cat cat dog";
        String letters = "abba";

        // When
        boolean result = subject.wordPattern(letters, sentence);

        // Then
        assertTrue(result);
    }

    @Test
    void wordPattern_whenCannotReplace_returnFalse() {

        // Given
        String sentence = "dog cat cat fish";
        String letters = "abba";

        // When
        boolean result = subject.wordPattern(letters, sentence);

        // Then
        assertFalse(result);
    }

    @Test
    void wordPattern_whenMultipleWordsForTheSameLetter_returnFalse() {

        // Given
        String sentence = "dog cat cat dog";
        String letters = "aaaa";

        // When
        boolean result = subject.wordPattern(letters, sentence);

        // Then
        assertFalse(result);
    }

    @Test
    void wordPattern_whenMultipleLettersForTheSameWord_returnFalse() {

        // Given
        String sentence = "dog dog dog dog";
        String letters = "abba";

        // When
        boolean result = subject.wordPattern(letters, sentence);

        // Then
        assertFalse(result);
    }

    @Test
    void wordPattern_whenMultipleLettersForTheSameWord2_returnFalse() {

        // Given
        String sentence = "dog cat dog";
        String letters = "abc";

        // When
        boolean result = subject.wordPattern(letters, sentence);

        // Then
        assertFalse(result);
    }
}
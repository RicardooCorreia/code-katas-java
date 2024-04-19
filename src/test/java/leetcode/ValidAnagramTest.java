package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidAnagramTest {

    private final ValidAnagram.Solution subject = new ValidAnagram.Solution();

    @Test
    void isAnagram_whenIsAnagram_returnTrue() {

        // Given
        String input1 = "anagram";
        String input2 = "nagaram";

        // When
        boolean result = subject.isAnagram(input1, input2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isAnagram_whenIsNotAnagram_returnFalse() {

        // Given
        String input1 = "rat";
        String input2 = "car";

        // When
        boolean result = subject.isAnagram(input1, input2);

        // Then
        assertThat(result)
                .isFalse();
    }
}
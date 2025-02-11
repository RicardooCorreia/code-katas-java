package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountingWordsWithGivenPrefixTest {

    private final CountingWordsWithGivenPrefix.Solution subject = new CountingWordsWithGivenPrefix.Solution();

    @Test
    void prefixCount_whenHasWords_returnCount() {

        // Given
        String[] input = {"pay", "attention", "practice", "attend"};

        // When
        int result = subject.prefixCount(input, "at");

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void prefixCount_whenHasNoWords_returnCount() {

        // Given
        String[] input = {"leetcode", "win", "loops", "success"};

        // When
        int result = subject.prefixCount(input, "code");

        // Then
        assertThat(result).isEqualTo(0);
    }
}
package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonPrefixTest {

    private final LongestCommonPrefix.Solution subject = new LongestCommonPrefix.Solution();

    @Test
    void longestCommonPrefix_returnsLongestPrefix() {

        // Given
        String[] input = {"flower", "flow", "flight"};

        // When
        String result = subject.longestCommonPrefix(input);

        // Then
        assertThat(result)
                .isEqualTo("fl");
    }

    @Test
    void longestCommonPrefix_whenNoCommonPrefix_returnEmpty() {

        // Given
        String[] input = {"dog", "racecar", "car"};

        // When
        String result = subject.longestCommonPrefix(input);

        // Then
        assertThat(result)
                .isEmpty();
    }
}
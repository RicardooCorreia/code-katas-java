package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumNumberOfStringPairsTest {

    private final FindMaximumNumberOfStringPairs.Solution subject = new FindMaximumNumberOfStringPairs.Solution();

    @Test
    void maximumNumberOfStringPairs_whenItHasMultiplePairs_returnCorrectPairs() {

        // Given
        String[] input = {"cd", "ac", "dc", "ca", "zz"};

        // When
        int result = subject.maximumNumberOfStringPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void maximumNumberOfStringPairs_whenItHaSinglePairs_returnCorrectPair() {

        // Given
        String[] input = {"ab", "ba", "cc"};

        // When
        int result = subject.maximumNumberOfStringPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void maximumNumberOfStringPairs_whenItHasNoPair_returnZero() {

        // Given
        String[] input = {"aa", "ab"};

        // When
        int result = subject.maximumNumberOfStringPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
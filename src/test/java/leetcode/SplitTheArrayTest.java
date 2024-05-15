package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitTheArrayTest {

    private final SplitTheArray.Solution subject = new SplitTheArray.Solution();

    @Test
    void isPossibleToSplit_whenIsPossible_returnTrue() {

        // Given
        int[] input = {1, 1, 2, 2, 3, 4};

        // When
        boolean result = subject.isPossibleToSplit(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isPossibleToSplit_whenIsPossible_returnFalse() {

        // Given
        int[] input = {1, 1, 1, 1};

        // When
        boolean result = subject.isPossibleToSplit(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isPossibleToSplit_whenIsNotPossibleAndMoreComplex_returnFalse() {

        // Given
        int[] input = {6, 1, 3, 1, 1, 8, 9, 2};

        // When
        boolean result = subject.isPossibleToSplit(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
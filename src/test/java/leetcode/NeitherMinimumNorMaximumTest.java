package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NeitherMinimumNorMaximumTest {

    private final NeitherMinimumNorMaximum.Solution subject = new NeitherMinimumNorMaximum.Solution();

    @Test
    void findNonMinOrMax_whenHasSingleSolution_returnResult() {

        // Given
        int[] input = {2, 1, 3};

        // When
        int result = subject.findNonMinOrMax(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void findNonMinOrMax_whenHasMultipleSolutions_returnResult() {

        // Given
        int[] input = {3, 2, 1, 4};

        // When
        int result = subject.findNonMinOrMax(input);

        // Then
        assertThat(result)
                .isIn(2, 3);
    }

    @Test
    void findNonMinOrMax_whenHasNoSolutions_returnMinusOne() {

        // Given
        int[] input = {1, 2};

        // When
        int result = subject.findNonMinOrMax(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}
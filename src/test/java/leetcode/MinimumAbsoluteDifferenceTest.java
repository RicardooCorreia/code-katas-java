package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumAbsoluteDifferenceTest {

    private final MinimumAbsoluteDifference.Solution subject = new MinimumAbsoluteDifference.Solution();

    @Test
    void minimumAbsDifference_whenHasMultipleInstances_returnCorrectResults() {

        // Given
        int[] input = {4, 2, 1, 3};

        // When
        List<List<Integer>> result = subject.minimumAbsDifference(input);

        // Then
        assertThat(result)
                .containsExactly(
                        List.of(1, 2),
                        List.of(2, 3),
                        List.of(3, 4)
                );
    }

    @Test
    void minimumAbsDifference_whenHasSingleInstances_returnCorrectResults() {

        // Given
        int[] input = {1, 3, 6, 10, 15};

        // When
        List<List<Integer>> result = subject.minimumAbsDifference(input);

        // Then
        assertThat(result)
                .containsExactly(
                        List.of(1, 3)
                );
    }

    @Test
    void minimumAbsDifference_whenHasNegativeNumbers_returnCorrectResults() {

        // Given
        int[] input = {3, 8, -10, 23, 19, -4, -14, 27};

        // When
        List<List<Integer>> result = subject.minimumAbsDifference(input);

        // Then
        assertThat(result)
                .containsExactly(
                        List.of(-14, -10),
                        List.of(19, 23),
                        List.of(23, 27)
                );
    }
}